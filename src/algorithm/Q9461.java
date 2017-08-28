package algorithm;
//파도반 수열
import java.util.*;

public class Q9461 {
	Scanner sc = new Scanner(System.in);
	void main(){
		int num = sc.nextInt();
		int value[] = new int[num+1];
		long dp[] = new long[101];
		for(int i=1; i<=num; i++){
			value[i] = sc.nextInt();
			System.out.println(padoBan(value[i], dp));
		}
			
	}
	long padoBan(int value, long[] dp){
		if(value <= 2){
			dp[value] = 1;
			dp[0] = 0;
		}
		else if(dp[value]==0)
			dp[value] = padoBan(value-2, dp) + padoBan(value-3, dp);
			
		return dp[value];
	}
	public static void main(String[] args) {
		new Q9461().main();
	}

}
