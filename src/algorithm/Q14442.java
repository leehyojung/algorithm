package algorithm;

import java.util.*;

//벽 부수고 이동하기2
//출력은 최단거리, 불가능할 경우 -1 출력한다.
//시간초과
public class Q14442 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };

	class Spot {
		int x, y, z;

		Spot(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	int N, M, K;
	int map[][];
	int check[][][]; // x, y와 몇번 벽을 깼는지 = 몇번째로 방문한 곳인지

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][M + 1];
		check = new int[N + 1][M + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		findShortCut();
	}

	private void findShortCut() {
		Queue<Spot> q = new LinkedList<Spot>();
		q.add(new Spot(1, 1, 0)); // input starting point in the queue.
		check[1][1][0] = 1; // arrive count.
		while (!q.isEmpty()) {
			Spot tmp = q.poll();
			if (tmp.x == N && tmp.y == M) {
				System.out.println(check[tmp.x][tmp.y][tmp.z]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (map[nx][ny] == 0 && check[nx][ny][tmp.z] == 0) {
						q.add(new Spot(nx, ny, tmp.z));
						check[nx][ny][tmp.z] = check[tmp.x][tmp.y][tmp.z] + 1;
					} else if (map[nx][ny] == 1 && tmp.z < K){
						if (check[nx][ny][tmp.z+1]==0) {
							q.add(new Spot(nx, ny, tmp.z + 1));
							check[nx][ny][tmp.z + 1] = check[tmp.x][tmp.y][tmp.z] + 1;
						}
					}
				}
			}
		}
		System.out.println("-1");
		return;
	}

	public static void main(String[] args) {
		new Q14442().init();
	}

}
