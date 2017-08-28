package algorithm;

import java.util.*;

//바이러스
public class Q2606 {
	int x;
	LinkedList<Integer>[] list;
	int[] check;

	void init() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		list = new LinkedList[x + 1];
		for (int i = 1; i <= x; i++) {
			list[i] = new LinkedList<Integer>();
		}
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		check = new int[x + 1];
		System.out.println(bfs(1));
	}

	private int bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		check[i] = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int a : list[x]) {
				if (check[a] == 0) {
					count += 1;
					check[a] = 1;
					q.add(a);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		new Q2606().init();
	}

}
