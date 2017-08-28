package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q2667 {
	int dx[] = {0,0,-1,1};
	int dy[] = {1,-1,0,0};
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int check[][] = new int[n][n];	//방문여부 0->방문안함 !0->각각의단지번호
	
	void init(){
		sc.nextLine();
		int map[][] = new int[n][n];	//지도
		for(int i=0; i<n; i++){
			String s = sc.nextLine();
			for(int j=0; j<n; j++){
				map[i][j] = s.charAt(j)-'0';
			}
		}
		int cnt = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j]==1 && check[i][j]==0){
					bfs(i, j, map, ++cnt);
				}
			}
		}
		System.out.println(cnt);
		
		int howMany[] = new int[cnt];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(check[i][j]!=0)
					howMany[check[i][j]-1] +=1;
				
			}
		}
		Arrays.sort(howMany);
		for(int i = 0; i<cnt; i++){
			System.out.println(howMany[i]);
		}
	}
	void bfs(int i, int j, int[][] map, int cnt) {
		Queue<Point> block = new LinkedList<Point>();
		block.offer(new Point(i,j));
		check[i][j] = cnt;
		while(!block.isEmpty()){
			int x = block.peek().x;
			int y = block.peek().y;
			block.poll();
			for(int d = 0; d<4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx>=0 && nx<n && ny>=0 && ny<n){
					if(map[nx][ny]==1 && check[nx][ny]==0){
						block.offer(new Point(nx, ny));
						check[nx][ny] = cnt;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q2667().init();
	}
}
