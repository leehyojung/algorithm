package algorithm;

import java.util.*;

// 숨바꼭질4
public class Q13913 {
	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	int N, K;
	int check[] = new int[100001];	//첫 번째 번호를 제외하고는 다 그 전의 번호를 기억하는 배열
	boolean visit[] = new boolean[100001];	//첫 번째 번호를 제외하고는 다 그 전의 번호를 기억하는 배열
	void init(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N==K){
			System.out.println("0");
			System.out.println(N);
			return;
		}
		if(N>K){
			System.out.println(N-K);
			for(int i=N; i>K; i--){
				System.out.print(i+" ");
			}
			System.out.println(K);
			return;
		}
		findSister();
	}
	void findSister(){
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(N, 0));
		check[N] = -1;
		visit[N] = true;
		while(!q.isEmpty()){
			Point x = q.poll();
			if(x.x == K){
				System.out.println(x.y);
				Stack<Integer> s = new Stack<Integer>();
				int tmp = x.x;
				while(check[tmp] != -1){
					s.push(check[tmp]);
					tmp = check[tmp];
				}
				while(!s.isEmpty()){
					System.out.print(s.pop()+" ");
				}
				System.out.println(x.x);
				return;
			}
			if (x.x * 2 <= 100000 && !visit[x.x * 2]) {
				visit[x.x * 2] = true;
				q.add(new Point(x.x * 2, x.y + 1));
				check[x.x * 2] = x.x;
			}
			if (x.x + 1 <= 100000 && !visit[x.x + 1]) {
				visit[x.x + 1] = true;
				q.add(new Point(x.x + 1, x.y + 1));
				check[x.x + 1] = x.x;
			}
			if (x.x - 1 >= 0 && !visit[x.x - 1]) {
				visit[x.x - 1] = true;
				q.add(new Point(x.x - 1, x.y + 1));
				check[x.x - 1] = x.x;
			}
		}
	}
	public static void main(String[] args) {
		new Q13913().init();
	}

}
