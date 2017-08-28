package algorithm;

import java.util.*;

public class Q11403_dfs {
	boolean check[];
	int map[][];
	LinkedList<Integer> list[];
	int N;
	void init(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new LinkedList[N+1];
		for(int i=1; i<=N; i++){
			list[i] = new LinkedList<Integer>();
		}
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				int x = sc.nextInt();
				if(x!=0)	list[i].add(j);
			}
		}
		for(int i=1; i<=N; i++){
			dfs(i, i);
		}
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
	private void dfs(int i, int first) {
		for(int a : list[i]){
			if(map[first][a] == 0){
				map[first][a] = 1;
				dfs(a, first);
			}
		}
	}
	public static void main(String[] args) {
		new Q11403_dfs().init();
	}

}
