package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q4963_1 {
	int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int[][] map;
	int[][] check;
	int w, h;

	void init() {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();

		while (w != 0 && h != 0) {
			map = new int[h + 1][w + 1];
			check = new int[h + 1][w + 1];
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] != 0 && check[i][j] == 0) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
			w = sc.nextInt();
			h = sc.nextInt();
		}

	}

	private void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = 1;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for (int a = 0; a < 8; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				if (nx > 0 && nx <= h && ny > 0 && ny <= w) {
					if (map[nx][ny] != 0 && check[nx][ny] == 0) {
						q.add(new Point(nx, ny));
						check[nx][ny] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q4963_1().init();
	}

}
