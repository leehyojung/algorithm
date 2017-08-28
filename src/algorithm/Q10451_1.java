package algorithm;

import java.util.*;

//순열 사이클
public class Q10451_1 {
	Scanner sc = new Scanner(System.in);
	LinkedList<Integer>[] list;
	boolean[] check;
	int result = 0;
	void init(){
		int test = sc.nextInt();
		
		while(test-- > 0){
			int num = sc.nextInt();
			list = new LinkedList[num+1];
			for(int i=1; i<=num; i++){
				list[i] = new LinkedList<Integer>();
			}
			for(int i=1; i<=num; i++){
				int x = sc.nextInt();
				list[i].add(x);
			}
			check = new boolean[num+1];
			for(int i=1; i<=num; i++){
				if(check[i]==false){
					bfs(i);
					result++;
				}
			}
			System.out.println(result);
			result = 0;
		}
	}
	private void bfs(int i) {
		check[i]=true;
		Queue<Integer> q = new LinkedList();
		q.add(i);
		while(!q.isEmpty()){
			int x = q.poll();
			for(int a : list[x]){
				if(check[a]==false){
					check[a]=true;
					q.add(a);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Q10451_1().init();
	}

}
