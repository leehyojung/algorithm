package algorithm;

import java.util.*;

//∞‘¿”
public class Q1103 {
	int N, M;
	int map[][];
	int max = 0;
	boolean infinity = false;
	int min[][];

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		min = new int[N + 1][M + 1];
		int[][] check = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		game(1, 1, 0, check);
		System.out.println(infinity == true ? "-1" : max);
	}

	private void game(int x, int y, int count, int[][] check) {
		if (x <= 0 || x > N || y <= 0 || y > M || map[x][y] == 24) {
			max = Math.max(max, count);
			return;
		}
		if (check[x][y] != 0) {
			infinity = true;
			return;
		}
		if (min[x][y] == 0) {
			min[x][y] = count;
		} else {
			if (min[x][y] >= count)
				return;
			else
				min[x][y] = count;
		}
		check[x][y] = count;
		for (int i = 0; i < 4; i++) {
			int temp[][] = new int[N + 1][M + 1];
			mapInint(check, temp);
			int nx = x;
			int ny = y;
			switch (i) {
			case 0:
				ny += map[x][y];
				break;
			case 1:
				nx += map[x][y];
				break;
			case 2:
				ny -= map[x][y];
				break;
			case 3:
				nx -= map[x][y];
				break;
			}
			game(nx, ny, count + 1, temp);
			if (infinity)
				break;
		}
	}

	private void mapInint(int[][] check, int[][] temp) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = check[i][j];
			}
		}
	}

	public static void main(String[] args) {
		new Q1103().init();
	}

}
