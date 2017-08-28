package algorithm;

import java.util.*;

public class Q2331_dfs {
	int check[] = new int[1000000];
	void init() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();
		int cnt = 1;
		System.out.println(length(A, P, cnt));
	}

	private int length(int a, int p, int cnt) {
		if(check[a]!=0){
			return check[a]-1;
		}
		check[a] = cnt;
		int ne = next(a, p);
		return length(ne, p, cnt+1);
	}
	private int next(int a, int b){
		int number = 0;
		while(a > 0){
			number += Math.pow(a%10, b);
			a /= 10;
		}
		return number;
	}

	public static void main(String[] args) {
		new Q2331_dfs().init();
	}
}
