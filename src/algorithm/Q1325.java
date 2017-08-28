package algorithm;

import java.util.*;

//효율적인 해킹
//방향 그래프인듯
public class Q1325 {
	int M, N;
	LinkedList<Integer>[] list;
	int check[];
	int visit[];
	void init(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		check = new int[N+1];
		list = new LinkedList[N+1];
		for(int i=1; i<=N; i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<M; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[y].add(x);
			check[x] = -1;
		}
		int max = 0;
		for(int i=1; i<=N; i++){
			bfs(i);
		}
		for(int i=1; i<=N; i++){
			max = Math.max(max, check[i]);
		}
		for(int i=1; i<=N; i++){
			if(max==check[i])	System.out.print(i+" ");
		}
	}
	private void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit = new int[N+1];
		q.add(x);
		visit[x] = 1;
		
		while(!q.isEmpty()){
			int a = q.poll();
			for(int b : list[a]){
				if(visit[b]==0){
					visit[b] = 1;
					check[x]+=1;
					q.add(b);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q1325().init();
	}

}
