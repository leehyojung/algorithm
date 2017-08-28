package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q1012 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int[][] map;
	int check[][];
	int n, m;
	void init(){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test-->0){
			n = sc.nextInt();
			m = sc.nextInt();
			int num = sc.nextInt();
			map = new int[m+1][n+1];
			check = new int[m+1][n+1];
		
			for(int i = 0; i<num; i++){
				int x = sc.nextInt()+1;
				int y = sc.nextInt()+1;
				map[y][x] = 1;
			}
			
			int count = 0;
			for(int i=1; i<=m; i++){
				for(int j=1; j<=n; j++){
					if(map[i][j]==1 && check[i][j]==0){
						bfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	private void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		check[i][j] = 1;
		while(!q.isEmpty()){
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int a=0; a<4; a++){
				int nx = x + dx[a];
				int ny = y + dy[a];
				if(nx>0 && nx<=m && ny>0 && ny<=n){
					if(map[nx][ny]==1 && check[nx][ny]==0){
						check[nx][ny] = 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	public static void main(String args[]){
		new Q1012().init();
	}
}
