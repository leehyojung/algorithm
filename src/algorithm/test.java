package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	int max = 0;
	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		dfs(map, N, 0);
		System.out.println(max);
	}
	void dfs(int map[][], int N, int count) {
		if (count == 5) {
			int num = maxNum(map, N);
			max = num > max ? num : max;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ch_map[][] = new int[N+1][N+1];
			mapInit(map, ch_map, N);
			switch (i) {
			case 0 : right(ch_map, N);
			break;
			case 1 : left(ch_map, N);
			break;
			case 2 : down(ch_map, N);
			break;
			case 3 : up(ch_map, N);
			break;
			}
			dfs(ch_map, N, count+1);
		}
	}
	int maxNum(int map[][], int N) {
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				max = map[i][j] > max ? map[i][j] : max;
			}
		}
		return max;
	}
	void mapInit(int map[][], int ch_map[][], int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ch_map[i][j] = map[i][j];
			}
		}
	}
	void left(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			int val = 1;
			for (int j = 2; j <= N; j++) {
				if (map[i][val] == 0  && map[i][j] == 0) continue;
				else if (map[i][val] == 0 && map[i][j] != 0) {
					map[i][val] = map[i][j] ;
					map[i][j] = 0;
				} else if (map[i][val] != 0 && map[i][j] == 0) continue;
				else if (map[i][val] == map[i][j]) {
					map[i][val++] *= 2;
					map[i][j] = 0;
				} else if (map[i][val] != map[i][j]) {
					if (map[i][val+1] == 0) {						
						map[i][val+1] = map[i][j];
						map[i][j] = 0;
					}
					val++;
				}
			}
		}
	}
	void right(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			int val = N;
			for (int j = N-1; j > 0; j--) {
				if (map[i][val] == 0  && map[i][j] == 0) continue;
				else if (map[i][val] == 0 && map[i][j] != 0) {
					map[i][val] = map[i][j] ;
					map[i][j] = 0;
				} else if (map[i][val] != 0 && map[i][j] == 0) continue;
				else if (map[i][val] == map[i][j]) {
					map[i][val--] *= 2;
					map[i][j] = 0;
				} else if (map[i][val] != map[i][j]) {
					if (map[i][val-1] == 0) {						
						map[i][val-1] = map[i][j];
						map[i][j] = 0;
					}
					val--;
				}
			}
		}
	}
	void up(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			int val = 1;
			for (int j = 2; j <= N; j++) {
				if (map[val][i] == 0  && map[j][i] == 0) continue;
				else if (map[val][i] == 0 && map[j][i] != 0) {
					map[val][i] = map[j][i] ;
					map[j][i] = 0;
				} else if (map[val][i] != 0 && map[j][i] == 0) continue;
				else if (map[val][i] == map[j][i]) {
					map[val++][i] *= 2;
					map[j][i] = 0;
				} else if (map[val][i] != map[j][i]) {
					if (map[val+1][i] == 0) {						
						map[val+1][i] = map[j][i];
						map[j][i] = 0;
					}
					val++;
				}
			}
		}
	}
	void down(int map[][], int N) {
		for (int i = 1; i <= N; i++) {
			int val = N;
			for (int j = N-1; j > 0; j--) {
				if (map[val][i] == 0  && map[j][i] == 0) continue;
				else if (map[val][i] == 0 && map[j][i] != 0) {
					map[val][i] = map[j][i] ;
					map[j][i] = 0;
				} else if (map[val][i] != 0 && map[j][i] == 0) continue;
				else if (map[val][i] == map[j][i]) {
					map[val--][i] *= 2;
					map[j][i] = 0;
				} else if (map[val][i] != map[j][i]) {
					if (map[val-1][i] == 0) {						
						map[val-1][i] = map[j][i];
						map[j][i] = 0;
					}
					val--;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new test().init();
	}
}
