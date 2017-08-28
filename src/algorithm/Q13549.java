package algorithm;

import java.util.*;

//숨바꼭질3
public class Q13549 {
	int N, K;
	int[] check = new int[100004];

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치
		if (N == K) {
			System.out.println("0");
			return;
		}
		else if(N > K){
			System.out.println(K-N);
			return;
		}
		findSister();
	}

	private void findSister() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		check[N] = 1;
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x * 2 <= 100000 && check[x * 2] == 0) {
				q.add(x * 2);
				check[x * 2] = check[x];
				if ((x * 2) == K) {
					System.out.println(check[x * 2] - 1);
					return;
				}
			}
			if (x + 1 <= 100000 && check[x + 1] == 0) {
				q.add(x + 1);
				check[x + 1] = check[x] + 1;
				if ((x + 1) == K) {
					System.out.println(check[x + 1] - 1);
					return;
				}
			}
			if (x - 1 >= 0 && check[x - 1] == 0) {
				q.add(x - 1);
				check[x - 1] = check[x] + 1;
				if ((x - 1) == K) {
					System.out.println(check[x - 1] - 1);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q13549().init();
	}

}
