package algorithm;

import java.util.*;

public class Q1389_dfs {
	LinkedList<Integer> list[];
	boolean check[];
	int count[];

	void init() {
		Scanner sc = new Scanner(System.in);
		int student = sc.nextInt();
		int relation = sc.nextInt();
		list = new LinkedList[student + 1];
		count = new int[student + 1];
		for (int i = 1; i <= student; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 1; i <= relation; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
//		for (int i = 1; i <= student; i++) {
			check = new boolean[student + 1];
//			dfs(i, i, 1);
//			System.out.println("end!!!");
//		}
		dfs(1, 1, 1);
		for (int i = 1; i <= student; i++) {
			System.out.println(count[i]);
		}
	}

	private void dfs(int i, int first, int cnt) {
		System.out.println(i + " " + cnt);
		check[i] = true;
		for (int a : list[i]) {
			if (check[a] == false) {
				count[first] += cnt;
				dfs(a, first, cnt+1);
			}
		}
	}

	public static void main(String[] args) {
		new Q1389_dfs().init();
	}

}
