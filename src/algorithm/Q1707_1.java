package algorithm;

import java.util.*;

//이분 그래프
public class Q1707_1 {
	Scanner sc = new Scanner(System.in);
	LinkedList<Integer>[] list;
	int[] check;
	void init(){
		int test = sc.nextInt();
		
		while(test-- > 0){
			int v = sc.nextInt();	//정점
			int e = sc.nextInt();	//간선
			check = new int[v+1];
			list = new LinkedList[v+1];
			for(int i=1; i<=v; i++){
				list[i] = new LinkedList<Integer>();
			}
			for(int i=0; i<e; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				list[x].add(y);
				list[y].add(x);
			}
			for(int i=1; i<=v; i++){
				if(check[i]==0)	bfs(i, 1);
			}
			boolean ok = true;
			for(int i=1; i<=v; i++){
				for(int k : list[i]){
					if(check[k]==check[i])	ok=false;
				}
			}
			System.out.println(ok?"YES":"NO");
		}
	}
	private void bfs(int i, int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[i] = c;
		q.add(i);
		while(!q.isEmpty()){
			int a = q.poll();
			for(int k : list[a]){
				if(check[k]==0){
					check[k] = 3-check[a];
					q.add(k);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q1707_1().init();
	}

}
