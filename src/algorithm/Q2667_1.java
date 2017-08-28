package algorithm;

import java.awt.*;
import java.util.*;
//단지번호 붙이기
public class Q2667_1 {
	int dx[] = {0,0,-1,1};
	int dy[] = {1,-1,0,0};
	Scanner sc = new Scanner(System.in);
	int test;
	int[][] map;
	int check[][];
	int result = 0;
	void init(){
		test = sc.nextInt();
		map = new int[test+1][test+1];
		check = new int[test+1][test+1];
		
		for(int i=1; i<=test; i++){
			String str = sc.next();
			for(int j=0; j<test; j++){
				map[i][j+1] = str.charAt(j)-'0';
			}
		}
		int cnt = 0;
		for(int i=1; i<=test; i++){
			for(int j=1; j<=test; j++){
				if(map[i][j]!=0 && check[i][j]==0){
					bfs(i, j,++cnt);
				}
			}
		}
		int[] num = new int[cnt];
		for(int i=1; i<=test; i++){
			for(int j=1; j<=test; j++){
				if(check[i][j]!=0){
					num[check[i][j]-1] += 1;
				}
			}
		}
		Arrays.sort(num);
		System.out.println(cnt);
		for(int i=0; i<num.length; i++){
			System.out.println(num[i]);
		}
	}

	private void bfs(int i, int j, int cnt) {
		Queue<Point> q = new LinkedList<Point>();
		check[i][j] = cnt;
		q.add(new Point(i, j));
		while (!q.isEmpty()) {
			int a = q.peek().x;
			int b = q.peek().y;
			q.poll();
			for (int x = 0; x < 4; x++) {
				int na = a + dx[x];
				int nb = b + dy[x];
				if (na > 0 && na <= test && nb > 0 && nb <= test) {
					if (map[na][nb] != 0 && check[na][nb] == 0) {
						check[na][nb] = cnt;
						q.add(new Point(na, nb));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q2667_1().init();
	}

}
