package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q7569 {
	public class spot {
		int x, y, z;

		spot(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	int h = sc.nextInt();
	int dh[] = { 0, 0, 0, 0, 1, -1 };
	int dn[] = { 0, 0, -1, 1, 0, 0 };
	int dm[] = { 1, -1, 0, 0, 0, 0 };
	Queue<spot> q = new LinkedList<spot>();
	spot sp;
	int map[][][];
	int check[][][];

	int init() {
		map = new int[h + 1][n + 1][m + 1];
		check = new int[h + 1][n + 1][m + 1];

		// input tomato.
		for (int a = 1; a <= h; a++) {
			for (int b = 1; b <= n; b++) {
				for (int c = 1; c <= m; c++) {
					map[a][b][c] = sc.nextInt();
					if (map[a][b][c] == 1) {
						check[a][b][c] = 1;
						q.add(new spot(a, b, c));
					} else if (map[a][b][c] == -1)
						check[a][b][c] = -1;
				}
			}
		}
		bfs();
		int max = 0;
		for (int a = 1; a <= h; a++) {
			for (int b = 1; b <= n; b++) {
				for (int c = 1; c <= m; c++) {
					if (check[a][b][c] == 0) {
						System.out.println("-1");
						return 0;
					}
					max = Math.max(max, check[a][b][c]);
				}
			}
		}
		System.out.println(max == 0 ? max : max - 1);
		return 0;
	}

	private void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int z = q.peek().z;
			q.poll();
			for (int a = 0; a < 6; a++) {
				int nh = x + dh[a];
				int nn = y + dn[a];
				int nm = z + dm[a];
				if (nh > 0 && nh <= h && nn > 0 && nn <= n && nm > 0 && nm <= m) {
					if (map[nh][nn][nm] == 0 && check[nh][nn][nm] == 0) {
						check[nh][nn][nm] = check[x][y][z] + 1;
						q.add(new spot(nh, nn, nm));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q7569().init();
	}

}
