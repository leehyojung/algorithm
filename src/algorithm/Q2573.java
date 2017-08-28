package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q2573 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int N, M;
	int[][] map;
	int[][] check;
	int temp[][];
	int total = 0;

	int init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		while (true) {
			count = 0;
			check = new int[N + 1][M + 1];
			temp = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] != 0 && check[i][j] == 0) {
						iceberg(i, j);
						count++;
					}
				}
			}
			if (count > 1) {
				System.out.println(total);
				return 0;
			}
			int c = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] != 0) {
						if (map[i][j] - temp[i][j] >= 0) {
							map[i][j] -= temp[i][j];
						} else
							map[i][j] = 0;
					}
					if (map[i][j] != 0)
						c++;
				}
			}
			if (c == 0) {
				System.out.println("0");
				return 0;
			}
			total += 1;
		}
	}

	private int iceberg(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = 1;
		while (!q.isEmpty()) {
			Point x = q.poll();
			int count = 0;
			for (int a = 0; a < 4; a++) {
				int nx = x.x + dx[a];
				int ny = x.y + dy[a];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (map[nx][ny] != 0 && check[nx][ny] == 0) {
						check[nx][ny] = 1;
						q.add(new Point(nx, ny));
					}
					if (map[nx][ny] == 0)
						count += 1;
				}
			}
			temp[x.x][x.y] = count;
		}

		return 0;
	}

	public static void main(String[] args) {
		new Q2573().init();
	}

}
