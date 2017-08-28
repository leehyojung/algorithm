package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//보물섬
//L(육지)마다 bfs돌려서 최대값 추출 max값이 답
public class Q2589 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int map[][];
	int check[][];
	int result[][];
	Scanner sc = new Scanner(System.in);
	int N, M;

	void init() {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		result = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j - 1) == 'W')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(max - 1);
	}

	private int bfs(int i, int j) {
		check = new int[N + 1][M + 1];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = 1;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for (int a = 0; a < 4; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (map[nx][ny] == 1 && check[nx][ny] == 0) {
						check[nx][ny] = check[x][y] + 1;
						result[i][j] = check[nx][ny];
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		return result[i][j];
	}

	public static void main(String[] args) {
		new Q2589().init();
	}

}
