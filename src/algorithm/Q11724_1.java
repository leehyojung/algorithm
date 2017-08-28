package algorithm;

import java.util.*;

//연결요소
public class Q11724_1 {
	static LinkedList<Integer>[] list;
	Scanner sc = new Scanner(System.in);
	static boolean[] check;
	
	void init(){		
		int component = 0;
		int n = sc.nextInt();	//정점의 갯수
		int m = sc.nextInt();	//간선의 갯수
		list = new LinkedList[n+1];
		check = new boolean[n+1];
		
		for(int i=1; i<=n; i++)
			list[i] = new LinkedList<Integer>();
		
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=n; i++){
			if(check[i]==false){
				bfs(i);
				component++;
			}
		}
		System.out.println(component);
	}
	private void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[x]=true;
		q.add(x);
		while(!q.isEmpty()){
			int y = q.poll();
			for(int i : list[y]){
				if(check[i]==false){
					q.add(i);
					check[i]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q11724_1().init();
	}
}
