package algorithm;

import java.util.*;

public class Q11403 {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[][] map;
	int[][] check;
	LinkedList<Integer> list[];
	int mapch[];
	void init(){
		map = new int[N+1][N+1];
		check = new int[N+1][N+1];
		list = new LinkedList[N+1];
		
		for(int i = 1; i<=N; i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==1){
					list[i].add(j);
				}
			}
		}
		mapch = new int[N+1];
		for(int i = 1; i<=N; i++){
			bfs(i);
		}
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<N; j++){
				System.out.print(check[i][j]+" ");
			}
			System.out.println(check[i][N]);
		}
	}
	private void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		while(!q.isEmpty()){
			int x = q.poll();
			for(int a : list[x]){
				if(check[i][a]==0){
					check[i][a] = 1;
					q.add(a);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new Q11403().init();
	}

}
