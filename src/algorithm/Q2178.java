package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

public class Q2178 {
	int dx[] = {0,0,-1,1};
	int dy[] = {1,-1,0,0};
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	void init(){
		sc.nextLine();
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++){
			String s = sc.nextLine();
			for(int j=0; j<m; j++)
				map[i][j] = s.charAt(j)-'0';
		}
		
		boolean check[][] = new boolean[n][m];
		int dist[][] = new int[n][m];
		dist[0][0] = 1;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j]==1 && check[i][j]==false)
					bfs(i, j, map, check, dist);
			}
		}
		
		System.out.println(dist[n-1][m-1]);
		
		
	}
	void bfs(int i, int j, int[][] map, boolean[][] check, int[][] dist) {
		Queue<Point> block = new LinkedList<Point>();
		block.offer(new Point(i, j));
		check[i][j] = true;
		while(!block.isEmpty()){
			int x = block.peek().x;
			int y = block.peek().y;
			block.poll();
			for(int a=0; a<4; a++){
				int ax = x + dx[a];
				int ay = y + dy[a];
				if(ax>=0 && ax<n && ay>=0 && ay<m){
					if(map[ax][ay]==1 && check[ax][ay]==false){
						block.offer(new Point(ax, ay));
						check[ax][ay] = true;
						dist[ax][ay] = dist[x][y] + 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q2178().init();
	}

}
