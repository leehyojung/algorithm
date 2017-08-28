package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q2583 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int[][] map;
	int[][] check;
	int n, m;
	void init(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		map = new int[n+1][m+1];
		check = new int[n+1][m+1];
		for(int i=0; i<k; i++){
			int a = sc.nextInt()+1;
			int b = sc.nextInt()+1;
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(int x=b; x<=d; x++){
				for(int y=a; y<=c; y++){
					map[x][y] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(map[i][j] == 0 && check[i][j]==0){
					bfs(i, j, ++cnt);
				}
			}
		}
		int list[] = new int[cnt+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(check[i][j]!=0)	list[check[i][j]]++;
			}
		}
		System.out.println(cnt);
		Arrays.sort(list);
		for(int i=1; i<=cnt; i++){
			System.out.print(list[i]+" ");
		}
	}
	private void bfs(int i, int j, int cnt) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = cnt;
		while(!q.isEmpty()){
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int a=0; a<4; a++){
				int nx = x + dx[a];
				int ny = y + dy[a];
				if(nx>0 && nx<=n && ny>0 && ny<=m){
					if(map[nx][ny]==0 && check[nx][ny]==0){
						check[nx][ny] = cnt;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	public static void main(String args[]){
		new Q2583().init();
	}
}
