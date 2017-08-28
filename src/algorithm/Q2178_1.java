package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q2178_1 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int map[][];
	int check[][];
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	int y = sc.nextInt();

	void init() {
		map = new int[x + 1][y + 1];
		check = new int[x + 1][y + 1];
		
		for (int i = 1; i <= x; i++) {
			String str = sc.next();
			for (int j = 0; j < y; j++) {
				map[i][j + 1] = str.charAt(j) - '0';
			}
		}
		
		bfs(1, 1);
		System.out.println(check[x][y]);
	}

	private void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = 1;

		while (!q.isEmpty()) {
			int a = q.peek().x;
			int b = q.peek().y;
			q.poll();
			for (int c = 0; c < 4; c++) {
				int nx = a + dx[c];
				int ny = b + dy[c];
				if (nx > 0 && nx <= x && ny > 0 && ny <= y) {
					if (map[nx][ny] != 0 && check[nx][ny] == 0) {
						check[nx][ny] = check[a][b] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q2178_1().init();
	}

}
