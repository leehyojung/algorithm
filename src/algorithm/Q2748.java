package algorithm;

import java.util.*;

//피보나치 함수 1<=num<=90
//***memorization!!!!
public class Q2748 {

	void main() {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long fibo_arr[] = new long[num + 1];

		System.out.println(fi(num, fibo_arr));

	}

	long fi(int num, long[] fibo_arr) {

		if (num <= 2) {
			fibo_arr[num] = 1;
			fibo_arr[0] = 0;
		} 
		else if (fibo_arr[num] == 0)
			fibo_arr[num] = fi(num - 1, fibo_arr) + fi(num - 2, fibo_arr);
		
		return fibo_arr[num];
	}

	public static void main(String[] args) {
		new Q2748().main();

	}

}
