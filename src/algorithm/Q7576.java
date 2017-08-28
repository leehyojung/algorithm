package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q7576 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	Queue<Point> tom = new LinkedList<Point>();

	int init() {
		int map[][] = new int[m][n];
		int dist[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					dist[i][j] = 1;
					tom.offer(new Point(i, j));
				}
			}
		}

		bfs(map, dist);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return 0;
				}
			}
		}

		int day = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				day = Math.max(day, dist[i][j]);
			}
		}
		if (day == 0)
			System.out.println(day);
		else
			System.out.println(day - 1);

		return 0;
	}

	void bfs(int[][] map, int[][] dist) {
		while (!tom.isEmpty()) {
			int x = tom.peek().x;
			int y = tom.peek().y;
			tom.poll();
			for (int a = 0; a < 4; a++) {
				int ax = x + dx[a];
				int ay = y + dy[a];
				if (ax >= 0 && ax < m && ay >= 0 && ay < n) {
					if (map[ax][ay] == 0) {
						tom.offer(new Point(ax, ay));
						map[ax][ay] = 1;
						dist[ax][ay] = dist[x][y] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q7576().init();
	}

}
