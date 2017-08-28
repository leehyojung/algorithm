package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//벽 부수고 이동하기
public class Q2206 {
	public class Po {
		int x, y, z;

		Po(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int map[][];
	int check[][][];
	int N, M;

	int init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		check = new int[N + 1][M + 1][3];

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j + 1] = str.charAt(j) - '0';
			}
		}
		if (N == 1 && M == 1) {
			System.out.println("0");
			return 0;
		}

		int result = bfs();
		System.out.println(result == 0 ? "-1" : result);

		return 0;
	}

	private int bfs() {
		Queue<Po> q = new LinkedList<Po>();
		q.add(new Po(1, 1, 1));
		check[1][1][1] = 1;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int z = q.peek().z;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					// 벽일때
					if (map[nx][ny] == 1 && z == 1 && check[nx][ny][z + 1] == 0) {
						check[nx][ny][z + 1] = check[x][y][z] + 1;
						q.add(new Po(nx, ny, z + 1));
					}
					// 방일때
					else if (map[nx][ny] == 0 && check[nx][ny][z] == 0) {
						check[nx][ny][z] = check[x][y][z] + 1;
						q.add(new Po(nx, ny, z));
					}
				}
			}
		}

		if (check[N][M][1] == 0 || check[N][M][2] == 0)
			return check[N][M][1] == 0 ? check[N][M][2] : check[N][M][1];

		return Math.min(check[N][M][1], check[N][M][2]);
	}

	public static void main(String[] args) {
		new Q2206().init();
	}

}
