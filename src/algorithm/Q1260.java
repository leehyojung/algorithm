package algorithm;

import java.util.*;

//dfs -> stack
//bfs -> queue
public class Q1260 {
	static boolean check[];
	static ArrayList<Integer>[] a;
	
	void init(){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();	//������ ����
		int e = sc.nextInt();	//������ ����
		int start = sc.nextInt();	//Ž���� ������ ������ ����
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
	//������ �̿��ؼ� �� �� �ִ¸�ŭ �ִ��� �� ��
	//�� �� ������ ���� �������� ���ư���
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
	//ť�� �̿��ؼ� ���� ��ġ���� �� �� �ִ� ������ ť�� �ִ´�
	//ť�� ���� �� �湮�ߴٰ� üũ�ؾ� ��
	void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = true;
		q.add(start);
		while(!q.isEmpty()){
			int x = q.remove();
			System.out.print(x + " ");
			//���� for�� -> �迭 ����� �ϳ��ϳ��� i������ �ѱ��.
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
