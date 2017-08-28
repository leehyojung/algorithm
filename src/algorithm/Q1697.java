package algorithm;

import java.util.*;
//숨바꼭질1
//bfs
public class Q1697 {
	int N, K;
	int[] check;
	int max = 0;
	int init(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//수빈이 위치
		K = sc.nextInt();	//동생 위치
		if(N==K){
			System.out.println("0");
			return 0;
		}
		max = 100000;
		check = new int[max+1];
		System.out.println(bfs()-1);
		return 0;
	}
	private int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		check[N] = 1;
		while(!q.isEmpty()){
			int x = q.poll();
			if(x+1>=0 && x+1<=max){
				if(check[x+1]==0){
					check[x+1] = check[x] + 1;
					q.add(x+1);
				}
				if(x+1 == K)	return check[x+1];
			}
			if(x-1>=0 && x-1<=max){
				if(check[x-1]==0){
					check[x-1] = check[x] + 1;
					q.add(x-1);
				}
				if(x-1 == K){
					return check[x-1];
				}
			}
			if(x*2>=0 && x*2<=max){
				if(check[x*2]==0){
					check[x*2] = check[x] + 1;
					q.add(x*2);
				}
				if(x*2 == K)	return check[x*2];
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		new Q1697().init();
	}

}
