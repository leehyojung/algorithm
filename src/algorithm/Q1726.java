package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//로봇
public class Q1726 {
	public class Po {
		int x, y, direction, cnt;

		Po(int x, int y, int direction, int cnt) {
			this.x = x;
			this.y = y;
			this.direction = direction; // 방향
			this.cnt = cnt; // 명령 수
		}
	}

	int dx[] = { 0, 0, 0, 1, -1 };
	int dy[] = { 0, 1, -1, 0, 0 };
	int N, M;
	int start_x, start_y, start_d;
	int end_x, end_y, end_d;
	int map[][];
	boolean check[][][];

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1][5];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		start_x = sc.nextInt();
		start_y = sc.nextInt();
		start_d = sc.nextInt();
		end_x = sc.nextInt();
		end_y = sc.nextInt();
		end_d = sc.nextInt();

		robot();
	}

	public void robot() {
		Queue<Po> q = new LinkedList<Po>();
		q.add(new Po(start_x, start_y, start_d, 0));
		check[start_x][start_y][start_d] = true;
		while (!q.isEmpty()) {
			// go 1, 2, 3 실행
			Po x = q.poll();
			if (x.x == end_x && x.y == end_y && x.direction == end_d) {
				System.out.println(x.cnt);
				return;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = x.x + dx[x.direction] * i;
				int ny = x.y + dy[x.direction] * i;

				if (nx <= 0 || nx > N || ny <= 0 || ny > M || map[nx][ny] == 1)
					break;

				if (check[nx][ny][x.direction] == false) {
					check[nx][ny][x.direction] = true;
					q.add(new Po(nx, ny, x.direction, x.cnt + 1));
				}
			}
			// 방향전환 실행
			for (int i = 1; i <= 4; i++) {
				if (i == x.direction || i == getdir(x.direction))
					continue;
				if (check[x.x][x.y][i] == false) {
					check[x.x][x.y][i] = true;
					q.add(new Po(x.x, x.y, i, x.cnt + 1));
				}
			}

		}
	}

	private int getdir(int direction) {
		if (direction == 1)
			return 2;
		else if (direction == 2)
			return 1;
		else if (direction == 4)
			return 3;
		else
			return 4;
	}

	public static void main(String[] args) {
		new Q1726().init();
	}

}
