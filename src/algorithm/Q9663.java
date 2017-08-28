package algorithm;

import java.util.*;

//N-Queen, Backtracking
public class Q9663 {
	int N;
	int result = 0;
	int queen[];

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N + 1];
		back_tracking(1);
		System.out.println(result);
	}

	private void back_tracking(int level) {
		if (level == N + 1) {
			result += 1;
			return;
		}
		for (int i = 1; i <= N; i++) {
			queen[level] = i;
			if (possible(level))
				back_tracking(level + 1);
		}
	}

	private boolean possible(int level) {
		for (int i = 1; i < level; i++) {
			if (queen[i] == queen[level] || Math.abs(level - i) == Math.abs(queen[level] - queen[i]))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		new Q9663().init();
	}

}
