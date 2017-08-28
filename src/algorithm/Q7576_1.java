package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q7576_1 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int map[][];
	int check[][];
	Queue<Point> q = new LinkedList<Point>();

	int init() {
		map = new int[m + 1][n + 1];
		check = new int[m + 1][n + 1];
		// input tomato map.
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1){
					q.add(new Point(i,j));
					check[i][j] = 1;
				}
				else if(map[i][j]==-1){
					check[i][j]=-1;
				}
			}
		}
		bfs();
		// Minimum number of days for which all tomatoes are ripe.
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[i][j] == 0) {
					System.out.println("-1");
					return 0;
				}
				max = Math.max(max, check[i][j]);
			}
		}
		System.out.println(max <= 0 ? "0" : max - 1);
		return 0;
	}

	private void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for (int a = 0; a < 4; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				if (nx > 0 && nx <= m && ny > 0 && ny <= n) {
					if (map[nx][ny] == 0 && check[nx][ny] == 0) {
						check[nx][ny] = check[x][y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q7576_1().init();
	}

}
