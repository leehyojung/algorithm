package algorithm;

import java.util.*;
//1,2,3 ¥ı«œ±‚
public class Q9095 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num+1];
		
		while(num!=0){
			arr[num] = sc.nextInt();
			System.out.println(onetwothree(arr[num]));
			num--;
		}

	}
	int onetwothree(int num){
		int plus[] = new int[12];
		
		plus[1] = 1;
		plus[2] = 2;
		plus[3] = 4;
		
		for(int i=4; i<=num; i++)
			plus[i] = plus[i-1] + plus[i-2] + plus[i-3];
			
		
		return plus[num];
	}
	public static void main(String[] args) {
		new Q9095().main();

	}

}
