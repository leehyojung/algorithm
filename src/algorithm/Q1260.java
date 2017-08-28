package algorithm;

import java.util.*;

//dfs -> stack
//bfs -> queue
public class Q1260 {
	static boolean check[];
	static ArrayList<Integer>[] a;
	
	void init(){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();	//정점의 갯수
		int e = sc.nextInt();	//간선의 갯수
		int start = sc.nextInt();	//탐색을 시작할 정점의 갯수
		a = new ArrayList[v+1];
		for(int i=1; i<=v; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=e; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		for(int i=1; i<=v; i++)
			Collections.sort(a[i]);
		
		check = new boolean[v+1];
		dfs(start);
		System.out.println();
		check = new boolean[v+1];
		bfs(start);
		System.out.println();
		
	}
	//스택을 이용해서 갈 수 있는만큼 최대한 갈 것
	//갈 수 없으면 이전 정점으로 돌아간다
	void dfs(int x) {
		if(check[x])
			return;
		check[x] = true;
		System.out.print(x + " ");
		for(int i:a[x]){
			if(check[i]==false)
				dfs(i);
		}
		
	}
	//큐를 이용해서 지금 위치에서 갈 수 있는 모든것을 큐에 넣는다
	//큐에 넣을 때 방문했다고 체크해야 함
	void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = true;
		q.add(start);
		while(!q.isEmpty()){
			int x = q.remove();
			System.out.print(x + " ");
			//향상된 for문 -> 배열 요소의 하나하나를 i값으로 넘긴다.
			for(int i : a[x]){
				if(check[i] == false){
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q1260().init();
	}

}
