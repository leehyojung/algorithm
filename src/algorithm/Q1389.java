package algorithm;

import java.util.*;

public class Q1389 {
	Scanner sc = new Scanner(System.in);
	int N, M;
	LinkedList<Integer>[] list;
	int check[];
	void init(){
		N = sc.nextInt();	//蜡历 荐
		M = sc.nextInt(); 	//模备包拌 荐
		list = new LinkedList[N+1];
		for(int i = 0 ; i<=N; i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=1; i<=M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		int min = 100;
		int result=0;
		for(int i=1; i<=N; i++){
			if(min>bfs(i)){
				min = bfs(i);
				result = i;
			}
		}
		System.out.println(result);
	}
	private int bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		check = new int[N+1];
		check[i] = 1;
		
		int total = 0;
		while(!q.isEmpty()){
			int x = q.poll();
			for(int a : list[x]){
				if(check[a]==0){
					check[a]=check[x]+1;
					total += check[a];
					q.add(a);
				}
			}
		}
		return total-N;
	}
	public static void main(String[] args) {
		new Q1389().init();
	}

}
