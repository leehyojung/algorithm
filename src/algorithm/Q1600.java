package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//말이 되고픈 원숭이
public class Q1600 {
	public class Po {
		int x, y, z;

		Po(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	int jdx[] = { -2, -1, -2, -1, 1, 2, 1, 2 };
	int jdy[] = { -1, -2, 1, 2, -2, -1, 2, 1 };
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int map[][];
	int check[][][];
	int K;
	int N, M; // 뒤바뀌어야 함 6 4 입력이면 map[4][6];

	int init() {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M + 1][N + 1];
		check = new int[M + 1][N + 1][K + 1];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		if(M==1 && N==1){
			System.out.println("0");
			return 0;
		}
		bfs();
		return 0;
	}

	private void bfs() {
		Queue<Po> q = new LinkedList<Po>();
		q.add(new Po(1, 1, 0));
		// 찬스 0번 씀
		check[1][1][0] = 1;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int z = q.peek().z;
			q.poll();
			// 숭이의 k가 남아있을 경우에
			if (z < K) {
				for (int j = 0; j < 8; j++) {
					int jnx = x + jdx[j];
					int jny = y + jdy[j];
					if (jnx > 0 && jnx <= M && jny > 0 && jny <= N) {
						if (map[jnx][jny] == 0) {
							if (check[jnx][jny][z + 1] == 0) {
								check[jnx][jny][z + 1] = check[x][y][z] + 1;
								q.add(new Po(jnx, jny, z + 1));

							} else {
								if (check[jnx][jny][z + 1] > check[x][y][z] + 1) {
									check[jnx][jny][z + 1] = check[x][y][z] + 1;
									q.add(new Po(jnx, jny, z + 1));
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= M && ny > 0 && ny <= N) {
					if (map[nx][ny] == 0 && check[nx][ny][z] == 0) {
						check[nx][ny][z] = check[x][y][z] + 1;
						q.add(new Po(nx, ny, z));
					}
				}
			}
		}
		
		int min = 40000;
		for (int i = 0; i <= K; i++) {
			if(check[M][N][i]!=0)
				min = Math.min(min, check[M][N][i]);
		}
		System.out.println(min==40000?"-1":min-1);
	}

	public static void main(String[] args) {
		new Q1600().init();
	}

}