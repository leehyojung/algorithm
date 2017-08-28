package algorithm;

import java.util.*;

//DSLR
//BFS
//시간초과
public class Q9019 {
	char arr[] = { 'D', 'S', 'L', 'R' };
	int A, B;
	int check[];
	char order[];
	int tmp[] = new int[4];
	Queue<Integer> q;
	Stack<Character> s;

	void init() {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			A = sc.nextInt();
			B = sc.nextInt();
			check = new int[10005]; // 내 번호 전 번호
			order = new char[10005]; // 이 번호로 올때 무슨 명령으로 왔는가
			howMany();
		}
	}

	private void howMany() {
		q = new LinkedList<Integer>();
		q.add(A);
		check[A] = A;
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == B) {
				s = new Stack<Character>();
				while (check[B] != A) {
					s.push(order[B]);
					B = check[B];
				}
				System.out.print(order[B]);
				while (!s.isEmpty()) {
					System.out.print(s.pop());
				}
				System.out.println();
				return;
			}
			tmp[0] = D(x);
			tmp[1] = S(x);
			tmp[2] = L(x);
			tmp[3] = R(x);
			for (int i = 0; i < 4; i++) {
				if (check[tmp[i]] == 0) {
					check[tmp[i]] = x;
					order[tmp[i]] = arr[i];
					q.add(tmp[i]);
				}
			}
		}
	}

	public int D(int var) {
		return (var * 2) % 10000;
	}

	public int S(int var) {
		if (var == 0)
			return 9999;
		return var - 1;
	}

	public int L(int var) {
		if (var == 0)
			return 0;
		int first = var / 1000;
		int last = var % 1000;
		return last * 10 + first;
	}

	public int R(int var) {
		if (var == 0)
			return 0;
		int k = var % 10;
		return k * 1000 + var / 10;
	}

	public static void main(String[] args) {
		new Q9019().init();
	}

}
