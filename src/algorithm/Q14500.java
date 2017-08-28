package algorithm;

import java.util.*;

//테트로미노
public class Q14500 {
	int N, M;
	int map[][];
	int temp[][]; // 끝난 칸들 담아놓는 곳
	int size;
	int max = 0;
	int dx[] = {0, 0, 1, -1};
	int dy[] = {-1, 1, 0, 0};
	boolean check[][];
	int sum = 0;
	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		temp = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				shape(i, j);
				game(i, j, 0);
				check[i][j] = true;
				sum=0;
			}
		}
		System.out.println(max);
	}

	private void shape(int x, int y) {
		int num = map[x][y];
		int min = 10000;
		int cnt = 0;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx > 0 && nx <= N && ny > 0 && ny <= M){
				cnt++;
				num += map[nx][ny];
				if(min > map[nx][ny])	min = map[nx][ny];
			}
		}
		if(cnt < 3)	return;
		if(cnt == 4)	num -= min;
		max = max > num ? max : num;
	}

	private void game(int x, int y, int count) {
		if (x <= 0 || x > N || y <= 0 || y > M || temp[x][y] != 0)
			return;
		if (count == 3) {
			if(check[x][y])	return;
			temp[x][y] = 1;
			sum += map[x][y];
			max = max > sum ? max : sum;
			temp[x][y] = 0;
			sum -= map[x][y];
			return;
		}
		for (int i = 0; i < 4; i++) {
			temp[x][y] = 1;
			sum += map[x][y];
			switch (i) {
			case 0:
				game(x - 1, y, count + 1);
				break;
			case 1:
				game(x, y + 1, count + 1);
				break;
			case 2:
				game(x + 1, y, count + 1);
				break;
			case 3:
				game(x, y - 1, count + 1);
				break;
			}
			temp[x][y] = 0;
			sum -= map[x][y];
		}
	}

	public static void main(String[] args) {
		new Q14500().init();
	}

}
