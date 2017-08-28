package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q4963 {
	int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	void init() {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();

		while (!(width == 0 && height == 0)) {
			int map[][] = new int[height][width];
			int check[][] = new int[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (map[i][j] == 1 && check[i][j] == 0) {
						bfs(i, j, width, height, map, check);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			width = sc.nextInt();
			height = sc.nextInt();
		}
	}

	void bfs(int i, int j, int width, int height, int[][] map, int[][] check) {
		Queue<Point> block = new LinkedList<Point>();
		block.offer(new Point(i, j));
		check[i][j] = 1;
		while (!block.isEmpty()) {
			int x = block.peek().x;
			int y = block.peek().y;
			block.poll();
			for (int a = 0; a < 8; a++) {
				int ax = x + dx[a];
				int ay = y + dy[a];
				if (ax >= 0 && ax < height && ay >= 0 && ay < width) {
					if (map[ax][ay] == 1 && check[ax][ay] == 0) {
						block.offer(new Point(ax, ay));
						check[ax][ay] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q4963().init();
	}
}
