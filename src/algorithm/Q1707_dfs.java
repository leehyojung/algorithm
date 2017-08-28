package algorithm;

import java.util.*;

public class Q1707_dfs {
	LinkedList<Integer> list[];
	int check[];
	void init(){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test-->0){
			int V = sc.nextInt();
			int E = sc.nextInt();
			list = new LinkedList[V+1];
			check =  new int[V+1];
			for(int i=1; i<=V; i++){
				list[i] = new LinkedList<Integer>();
			}
			for(int i=0; i<E; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				list[x].add(y);
				list[y].add(x);
			}
			for(int i=1; i<=V; i++){
				if(check[i]==0)	dfs(i, 1);
			}
			System.out.println(checkGrape(V)==0?"YES":"NO");
		}
	}
	private void dfs(int i, int j) {
		check[i] = j;
		for(int x : list[i]){
			if(check[x]==0)	dfs(x, 3-j);
		}
	}
	private int checkGrape(int V) {
		for(int i=1; i<=V; i++){
			for(int j : list[i]){
				if(check[i] == check[j]){
					return 1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		new Q1707_dfs().init();
	}

}
