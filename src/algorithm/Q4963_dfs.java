package algorithm;

import java.util.*;

public class Q4963_dfs {
	int dx[] = { -1, 0, 1, 0, -1, -1, 1, 1 };
	int dy[] = { 0, 1, 0, -1, -1, 1, -1, 1 };
	int map[][];
	int check[][];
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
			int cnt = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == 1 && check[i][j] == 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}

	private void dfs(int i, int j) {
		check[i][j] = 1;
		for (int a = 0; a < 8; a++) {
			int nx = i + dx[a];
			int ny = j + dy[a];
			if (nx > 0 && nx <= h && ny > 0 && ny <= w) {
				if (map[nx][ny] == 1 && check[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q4963_dfs().init();
	}

}
