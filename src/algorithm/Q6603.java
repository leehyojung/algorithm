package algorithm;

import java.util.*;
//·Î¶Ç
public class Q6603 {
	static int N;
	static int num[];
	static int temp[] = new int[6];

	void init() {
		Scanner sc = new Scanner(System.in);

		while ((N = sc.nextInt()) != 0) {
			num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			combi(0, 0);
			System.out.println();
		}
	}

	public static void combi(int k, int r) {
		System.out.println("k= "+ k + "r= " + r);
		if (r == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(temp[i] + " ");
			}

			System.out.println();
		} else if (k > N - 1) {
			return;
		} else {
			temp[r] = num[k];
			combi(k + 1, r + 1);
			combi(k + 1, r);
		}

	}	

	public static void main(String[] args) {
		new Q6603().init();
	}

}
