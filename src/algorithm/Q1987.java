package algorithm;

import java.util.*;

//알파벳, 백트래킹
public class Q1987 {
	int dx[] = { 0, -1, 0, 1 };
	int dy[] = { -1, 0, 1, 0 };
	int map[][];
	boolean number[] = new boolean[27];
	int x, y;
	int max = 1;

	void init() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		map = new int[x + 1][y + 1];

		for (int i = 1; i <= x; i++) {
			String str = sc.next();
			for (int j = 1; j <= y; j++) {
				map[i][j] = str.charAt(j - 1) - 'A';
			}
		}
		number[map[1][1]] = true;
		dfs(1, 1, 1);
		System.out.println(max);
	}
	
	private void dfs(int i, int j, int k) {
		number[map[i][j]] = true;
		for (int a = 0; a < 4; a++) {
			int nx = i + dx[a];
			int ny = j + dy[a];
			if (nx > 0 && nx <= x && ny > 0 && ny <= y) {
				if (!number[map[nx][ny]]) {
					number[map[nx][ny]] = true;
					max = Math.max(max, k + 1);
					dfs(nx, ny, k + 1);
				}
			}
		}
		number[map[i][j]] = false;
	}

	public static void main(String[] args) {
		new Q1987().init();
	}

}
