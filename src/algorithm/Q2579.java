package algorithm;
//계단오르기
import java.util.*;

public class Q2579 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int value[] = new int[num+1];
		for(int i=1; i<=num; i++)
			value[i] = sc.nextInt();
		
		stairSum(num, value);
	}
	void stairSum(int num, int[] value){
		int dp[] = new int[num+1];
		if(num!=0)
			dp[1] = value[1];
		if(num >= 2){
			dp[2] = dp[1] + value[2];
			for(int i=3; i<=num; i++){
				dp[i] = Math.max(dp[i-3]+value[i-1]+value[i], dp[i-2]+value[i]);
			}
		}
		System.out.println(dp[num]);
	}
	public static void main(String[] args) {
		new Q2579().main();
	}

}
