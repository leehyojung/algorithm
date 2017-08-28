package algorithm;

import java.awt.*;
import java.util.*;

public class Q3190_1 {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); // 보드판
	int apple = sc.nextInt();
	int map[][];
	int check[][];
	Deque<Point> q; // 뱀
	Queue con; // 방향전환
	int second = 0;
	int direction = 1;

	void init() {
		q = new LinkedList<Point>();
		map = new int[N + 1][N + 1];
		check = new int[N + 1][N + 1];

		for (int i = 0; i < apple; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}

		con = new LinkedList();
		int control = sc.nextInt();
		for (int i = 0; i < control; i++) {
			int x = sc.nextInt();
			String c = sc.next();
			con.add(x);
			con.add(c);
		}
		q.addFirst(new Point(1, 1)); // 뱀의 첫번째 위치
		check[1][1] = 1;
		while (move());
		System.out.println(second);
	}

	private boolean move() {
		
		if (con.peek().equals(second)) {
			con.poll();
			chdir(con.poll().toString());
		}
		second += 1;
		int x = q.peekFirst().x;
		int y = q.peekFirst().y;

		if (direction == 1) {
			y += 1;
		} else if (direction == 2) {
			y -= 1;
		} else if (direction == 3) {
			x -= 1;
		} else {
			x += 1;
		}
		
		if (x > 0 && x <= N && y > 0 && y <= N) {
			if(check[x][y] == 1)
				return false;
			else{
				q.addFirst(new Point(x, y));
				check[x][y] = 1;
				if (map[x][y] == 1) {
					map[x][y] = 0;
				} else {
					check[q.peekLast().x][q.peekLast().y] = 0;
					q.pollLast();
				}
			}
		} else // 벽 만난거
			return false;
		return true;
	}

	private void chdir(String c) {
		if (direction == 1) {
			if (c.equals("D"))
				direction = 4;
			else
				direction = 3;
		} else if (direction == 2) {
			if (c.equals("D"))
				direction = 3;
			else
				direction = 4;
		} else if (direction == 3) {
			if (c.equals("D"))
				direction = 1;
			else
				direction = 2;
		} else {
			if (c.equals("D"))
				direction = 2;
			else
				direction = 1;
		}
	}

	public static void main(String[] args) {
		new Q3190_1().init();
	}

}
