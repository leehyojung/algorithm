package algorithm;

import java.util.*;

//가장 긴 증가하는 부분수열의 길이 구하기
public class Q11053 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int value[] = new int[num+1];
		for(int i=1; i<=num; i++){
			value[i] = sc.nextInt();
		}
		
		howLong(num, value);
	}
	void howLong(int num, int[] value){
		int dp[] = new int[num+1];
		dp[1] = 1;
		int result = 0;

		for(int i=2; i<=num; i++){
			for(int j=1; j<i; j++){	
				if(value[i] > value[j]){
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] = dp[i]+1;
		}
		for(int i=2; i<=num; i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);

	}
	public static void main(String[] args) {
		new Q11053().main();
	}

}
