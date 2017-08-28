package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//숨바꼭질2
//78%에서 틀립
public class Q12851 {
	int N, K;
	boolean check[] = new boolean[100001];
	int result = 0;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치
		if (N >= K) {
			System.out.println(N - K);
			System.out.println("1");
			return;
		}
		findSister();
	}

	private void findSister() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(N, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point x = q.poll();
				check[x.x] = true;
				
				if (K == x.x) {
					result++;
					while (!q.isEmpty()) {
						Point tmp = q.poll();
						if (x.y == tmp.y) {
							if (K == tmp.x)
								result++;
						} else {
							System.out.println(x.y);
							System.out.println(result);
							return;
						}
					}
					System.out.println(x.y);
					System.out.println(result);
					return;
				}

				if (x.x + 1 <= 100000 && !check[x.x + 1]) {
					q.add(new Point(x.x + 1, x.y + 1));
				}
				if (x.x - 1 >= 0 && !check[x.x - 1]) {
					q.add(new Point(x.x - 1, x.y + 1));
				}
				if (x.x * 2 <= 100000 && !check[x.x * 2]) {
					q.add(new Point(x.x * 2, x.y + 1));
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q12851().init();
	}

}
