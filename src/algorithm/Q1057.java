package algorithm;

import java.util.*;

//토너먼트
public class Q1057 {
	int init(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int result = 0;
		
		if(num < A || num < B){
			System.out.println("-1");
			return 0;
		}
		
		while(A!=B){
			A = A/2 + A%2;
			B = B/2 + B%2;
			result+=1;
		}
		System.out.println(result);
		return 0;
		
	}
	public static void main(String[] args) {
		new Q1057().init(); 
	}

}
