package algorithm;

import java.util.*;

public class Q5532 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		if (A % C == 0)
			A /= C;
		else
			A = A/C + 1;
		
		if (B % D == 0)
			B /= D;
		else
			B = B/D + 1;
		System.out.println(A >= B ? L-A : L-B);
	}

	public static void main(String[] args) {
		new Q5532().init();
	}

}
