package algorithm;

import java.util.*;

public class Q11724_dfs {
	LinkedList<Integer> list[];
	boolean check[];
	void init(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		list = new LinkedList[N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<M; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		int count = 0;
		for(int i=1; i<=N; i++){
			if(!check[i]){
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	private void dfs(int i) {
		check[i] = true;
		for(int x : list[i]){
			if(!check[x]){
				dfs(x);
			}
		}
	}
	public static void main(String[] args) {
		new Q11724_dfs().init();
	}

}
