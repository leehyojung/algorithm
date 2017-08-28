package algorithm;

import java.util.*;

//연결요소
//dfs
//스택을 이용해서 갈 수 있는만큼 최대한 갈 것
//갈 수 없으면 이전 정점으로 돌아간다
public class Q11724 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	void init(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//정점의 개수
		int m = sc.nextInt();	//간선의 개수
		int component = 0;
		
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		check = new boolean[n+1];
		
		for(int i=1; i<=n; i++){
			if(check[i]==false){
				bfs(i);
				component+=1;
			}
		}
		System.out.println(component);
	}
	void bfs(int x){
		if(check[x])
			return;
		check[x] = true;
		for(int i:a[x]){
			if(check[i]==false){
				bfs(i);
			}
		}
	}
	public static void main(String[] args) {
		new Q11724().init();
	}

}
