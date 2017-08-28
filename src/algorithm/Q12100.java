package algorithm;

import java.util.*;

public class Q12100 {
	int N;
	int max = 0;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		game2048(map, 0);
		System.out.println(max);
	}

	private void game2048(int[][] map, int count) {
		if (count == 5) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[][] temp = new int[N + 1][N + 1];
			mapInit(map, temp);
			switch (i) {
			case 0:
				up(temp);
				break;
			case 1:
				down(temp);
				break;
			case 2:
				right(temp);
				break;
			case 3:
				left(temp);
				break;
			}
			game2048(temp, count + 1);
		}
	}

	private void mapInit(int[][] map, int[][] temp) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	private void up(int[][] map) {
		int[][] temp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[j][i] == 0)
					continue;
				else {
					for (int k = j + 1; k <= N; k++) {
						if (map[k][i] == 0)
							continue;
						else if (map[j][i] == map[k][i]) {
							map[j][i] *= 2;
							map[k][i] = 0;
							break;
						} else
							break;
					}
				}
			}
			int cnt = 1;
			for (int j = 1; j <= N; j++) {
				if (map[j][i] == 0)
					continue;
				else
					temp[cnt++][i] = map[j][i];
			}
		}
		mapInit(temp, map);
	}

	private void down(int[][] map) {
		int[][] temp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				if (map[j][i] == 0)
					continue;
				else {
					for (int k = j - 1; k > 0; k--) {
						if (map[k][i] == 0)
							continue;
						else if (map[j][i] == map[k][i]) {
							map[j][i] *= 2;
							map[k][i] = 0;
							break;
						} else
							break;
					}
				}
			}
			int cnt = N;
			for (int j = N; j > 0; j--) {
				if (map[j][i] == 0)
					continue;
				else
					temp[cnt--][i] = map[j][i];
			}
		}
		mapInit(temp, map);
	}

	private void right(int[][] map) {
		int[][] temp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				if (map[i][j] == 0)
					continue;
				else {
					for (int k = j - 1; k > 0; k--) {
						if (map[i][k] == 0)
							continue;
						else if (map[i][j] == map[i][k]) {
							map[i][j] *= 2;
							map[i][k] = 0;
							break;
						} else
							break;
					}
				}
			}
			int cnt = N;
			for (int j = N; j > 0; j--) {
				if (map[i][j] == 0)
					continue;
				else
					temp[i][cnt--] = map[i][j];
			}
		}
		mapInit(temp, map);
	}

	private void left(int[][] map) {
		int[][] temp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0)
					continue;
				else {
					for (int k = j + 1; k <= N; k++) {
						if (map[i][k] == 0)
							continue;
						else if (map[i][j] == map[i][k]) {
							map[i][j] *= 2;
							map[i][k] = 0;
							break;
						} else
							break;
					}
				}
			}
			int cnt = 1;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0)
					continue;
				else
					temp[i][cnt++] = map[i][j];
			}
		}
		mapInit(temp, map);
	}

	public static void main(String[] args) {
		new Q12100().init();
	}

}
