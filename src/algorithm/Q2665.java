package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;


//미로만들기
public class Q2665 {

	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int[][] map;
	int[][] check;
	int N;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		check = new int[N + 1][N + 1];
		// 0은 검은방 1은 흰방
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j + 1] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	private int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(1, 1));
		check[1][1] = 1;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
					// 흰 방이다!
					if (map[nx][ny] == 1) {
						if (check[nx][ny] == 0) {
							check[nx][ny] = check[x][y];
							q.add(new Point(nx, ny));
						} else {
							if (check[nx][ny] > check[x][y]){
								check[nx][ny] = check[x][y];
								q.add(new Point(nx, ny));
							}
						}
					}
					// 검은 방이다!
					if (map[nx][ny] == 0) {
						if (check[nx][ny] == 0) {
							check[nx][ny] = check[x][y] + 1;
							q.add(new Point(nx, ny));
						} else {
							if (check[nx][ny] > check[x][y]+1){
								check[nx][ny] = check[x][y]+1;
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}
		}
		return check[N][N]-1;
	}

	public static void main(String[] args) {
		new Q2665().init();
	}
}
