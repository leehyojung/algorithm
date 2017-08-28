package algorithm;

import java.util.*;

//피보나치 함수 1<=n<=45
//***memorization!!!!
public class Q2747 {

	void main() {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fibo_arr[] = new int[num+1];
		
		System.out.println(fi(num, fibo_arr));

	}
	int fi(int num, int[] fibo_arr){
		if(num<=2){
			fibo_arr[num]=1;
			fibo_arr[0]=0;
		}
		else if(fibo_arr[num]==0)
			fibo_arr[num] = fi(num-1, fibo_arr) + fi(num-2, fibo_arr);
		return fibo_arr[num];
	}
	
	public static void main(String[] args) {
		new Q2747().main();

	}

}
