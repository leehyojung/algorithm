package algorithm;

import java.util.*;

//이분 그래프
public class Q1707 {
	static ArrayList<Integer>[] a;
	int check[];
	
	void init(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while (num-->0) {
			int n = sc.nextInt();	//정점의 갯수
			int m = sc.nextInt();	//간선의 갯수
			a = new ArrayList[n + 1];
			check = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = new ArrayList<Integer>();

			for (int i = 1; i <= m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}

			for (int i = 1; i <= n; i++) {
				if (check[i] == 0)
					bipartiteGraph(i, 1);
			}

			//비교하기
			boolean ok = true;
			for(int i=1; i<=n; i++){
				for(int j : a[i]){
					int z = a[i].get(j);
					if(check[z]==check[i])
						ok=false;
				}
			}
			System.out.println(ok ? "YES" : "NO");
		}
	}
	void bipartiteGraph(int node, int x){
		check[node] = x;
		for(int i:a[node]){
			if(check[i]==0)
			bipartiteGraph(i, 3-x);
		}
		
	}
	public static void main(String[] args) {
		new Q1707().init();
	}

}
