package algorithm;

import java.util.*;

public class Q2580 {
	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int map[][] = new int[10][10];
	LinkedList<Point> list;
	int size;
	boolean ok = false;
	int max = 0;
	void init() {
		Scanner sc = new Scanner(System.in);
		list = new LinkedList<Point>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					list.add(new Point(i, j));
				}
			}
		}
		size = list.size();
		sudoku(0);
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void sudoku(int count) {
		if (size == count) {
			ok = true;
			return;
		}
		for (int i = 1; i < 10; i++) {
			int x = list.get(count).x;
			int y = list.get(count).y;
			map[x][y] = i;
			if (isPossible(x, y)) {
				sudoku(count + 1);
				if (ok)
					break;
			}
			map[x][y] = 0;
		}
	}

	private boolean isPossible(int x, int y) {
		// 가로, 세로, 네모박스 검사
		boolean check[] = new boolean[10];
		for (int i = 1; i < 10; i++) {
			if(!check[map[i][y]]){
				if(map[i][y] !=0)
					check[map[i][y]]=true;
			}
			else return false;
		}
		
		check = new boolean[10];
		for (int i = 1; i < 10; i++) {
			if(!check[map[x][i]]){
				if(map[x][i] !=0)
					check[map[x][i]]=true;
			}
			else return false;
		}
		check = new boolean[10];
		if (x < 4)	x = 1;
		else if (x > 6)	x = 7;
		else	x = 4;
		if (y < 4)	y = 1;
		else if (y > 6)	y = 7;
		else	y = 4;
		for (int i = x; i <= x + 2; i++) {
			for (int j = y; j <= y + 2; j++) {
				if(!check[map[i][j]]){
					if(map[i][j] !=0)
						check[map[i][j]]=true;
				}
				else return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new Q2580().init();
	}

}

