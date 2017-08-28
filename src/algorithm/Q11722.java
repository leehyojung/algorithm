package algorithm;

import java.util.*;
//가장 긴 감소하는 부분수열의 길이
public class Q11722 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int value[] = new int[num+1];
		for(int i=1; i<=num; i++){
			value[i] = sc.nextInt();
		}
		
		howShort(num, value);
	}
	void howShort(int num, int[] value){
		int dp[] = new int[num+1];
		dp[num] = 1;
		int result = 0;

//		for(int i=2; i<=num; i++){
//			for(int j=1; j<i; j++){	
//				if(value[i] < value[j]){
//					dp[i] = Math.max(dp[i], dp[j]);
//				}
//			}
//			dp[i] = dp[i]+1;
//		}
		for(int i=num-1; i>=1; i--){
			for(int j=num; j>i; j--){	
				if(value[i] > value[j]){
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] = dp[i]+1;
		}
		
		for(int i=1; i<=num; i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);

	}
	public static void main(String[] args) {
		new Q11722().main();
	}

}
