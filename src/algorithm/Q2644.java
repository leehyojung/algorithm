package algorithm;

import java.util.*;

public class Q2644 {
	int x, y;
	LinkedList<Integer> list[];
	int[] check;
	int people;
	void init(){
		Scanner sc = new Scanner(System.in);
		people = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		list = new LinkedList[people+1];
		for(int i =1; i<=people; i++){
			list[i] = new LinkedList<Integer>();
		}
		int put = sc.nextInt();
		for(int i = 0; i<put; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		System.out.println(bfs());
	}
	private int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		check = new int[people+1];
		q.add(x);
		check[x] = 1;
		while(!q.isEmpty()){
			int a = q.poll();
			for(int k : list[a]){
				if(check[k]==0){
					check[k] = check[a]+1;
					if(k==y)	return check[k]-1;
					q.add(k);
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		new Q2644().init();
	}

}
