package algorithm;

import java.awt.*;
import java.util.*;

//안전영역
public class Q2468 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int N;
	int map[][];
	boolean check[][];
	int max = 0, min = 100;
	int result = 0 ;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		if(max == min){
			System.out.println("1");
			return;
		}
		while(min<=max){
			//침수
			check = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] <= min){
						map[i][j] = 0;
						check[i][j] = true;
					}
				}
			}

			//영역 몇개인지 구해랑!!
			int temp = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(check[i][j] == false){
						bfs(i, j);
						temp += 1;
					}
				}
			}
			if(temp == 0)	break;
			result = Math.max(result, temp);
			min+=1;
		}
		System.out.println(result);
	}

	private void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = true;
		while(!q.isEmpty()){
			Point x = q.poll();
			for(int a = 0; a<4; a++){
				int nx = x.x + dx[a];
				int ny = x.y + dy[a];
				if(nx > 0 && nx <= N && ny > 0 && ny <= N){
					if(check[nx][ny] == false){
						check[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q2468().init();
	}

}
