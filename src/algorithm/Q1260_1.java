package algorithm;

import java.util.*;

public class Q1260_1 {
	static boolean check[];
	static LinkedList<Integer>[] a;
	void init(){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//����
		int m = sc.nextInt();	//����
		int start = sc.nextInt();	//Ž���� ������ ������ ��ȣ
		
		a = new LinkedList[n+1];
		
		for(int i=1; i<=n; i++){
			a[i] = new LinkedList<Integer>();
		}
		
		for(int i=1; i<=m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		for(int i=1; i<=n; i++){
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		bfs(start);
		System.out.println();
	}
	//���� �켱 Ž��, stack���
	void dfs(int start){
		check[start] = true;
		System.out.print(start + " ");
		for(int i=0; i<a[start].size(); i++){
			int x = a[start].get(i);
			if(check[x]==false){
				dfs(x);
			}
		}
	}
	//�ʺ� �켱 Ž��, queue���
	void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = true;
		q.add(start);
		while(!q.isEmpty()){
			int x = q.remove();
			System.out.printf(x + " ");
			for(int i : a[x]){
				if(check[i]==false){
					check[i]=true;
					q.add(i);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new Q1260_1().init();
	}

}
