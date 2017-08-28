package algorithm;

import java.util.*;

public class Q2667_dfs {
	int dx[] = { -1, 0, 1, 0 };
	int dy[] = { 0, 1, 0, -1 };
	int map[][];
	int check[][];
	int N;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = 0;
		map = new int[N + 1][N + 1];
		check = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && check[i][j] == 0) {
					dfs(i, j, cnt += 1);
				}
			}
		}
		System.out.println(cnt);
		int count[] = new int[cnt];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(check[i][j]!=0){
					count[check[i][j]-1]++;
				}
			}
		}
		Arrays.sort(count);
		for(int i : count){
			System.out.println(i);
		}
	}

	private void dfs(int i, int j, int cnt) {
		check[i][j] = cnt;
		for(int a=0; a<4; a++){
			int nx = i + dx[a];
			int ny = j + dy[a];
			if(nx > 0 && nx <= N && ny > 0 && ny <= N){
				if(map[nx][ny]==1 && check[nx][ny] == 0){
					dfs(nx, ny, cnt);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q2667_dfs().init();
	}

}
