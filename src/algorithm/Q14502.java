package algorithm;

import java.util.*;

//연구소
public class Q14502 {
	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int dx[] = { 0, -1, 0, 1 };
	int dy[] = { -1, 0, 1, 0 };
	int N, M;
	int map[][];
	Queue<Point> q;
	LinkedList<Point> list;
	int size;
	int max = 0;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		q = new LinkedList<Point>(); // 바이러스
		list = new LinkedList<Point>(); // 벽이 들어 갈 수 있는 빈 공간
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					q.add(new Point(i, j));
				else if (map[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		size = list.size();
		safeArea(0, 0, map);
		System.out.println(max);
	}

	private void safeArea(int num, int count, int[][] map) {
		if (count == 3) {
			virusSpread(map);
			int find = howManySafeArea(map);
			max = max > find ? max : find;
			return;
		}
		if (num >= size)
			return;
		for (int i = 0; i < 2; i++) {
			int temp[][] = new int[N + 1][M + 1];
			mapInit(map, temp);
			temp[list.get(num).x][list.get(num).y] = 1;
			switch (i) {
			case 0:
				safeArea(num + 1, count + 1, temp);
				break;
			case 1:
				temp[list.get(num).x][list.get(num).y] = 0;
				safeArea(num + 1, count, temp);
				break;
			}
		}
	}

	private int howManySafeArea(int[][] temp) {
		int num = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (temp[i][j] == 0)
					num += 1;
			}
		}
		return num;
	}

	private void virusSpread(int[][] temp) {
		Queue<Point> tempq = new LinkedList<Point>();

		int qsize = q.size();
		for (int i = 0; i < qsize; i++) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			q.add(new Point(x, y));
			tempq.add(new Point(x, y));
		}

		while (!tempq.isEmpty()) {
			int x = tempq.peek().x;
			int y = tempq.peek().y;
			tempq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (temp[nx][ny] == 0) {
						temp[nx][ny] = 2;
						tempq.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	private void mapInit(int[][] map, int[][] temp) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	public static void main(String[] args) {
		new Q14502().init();
	}

}
