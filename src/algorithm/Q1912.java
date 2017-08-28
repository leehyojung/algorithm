package algorithm;
//¿¬¼ÓÇÕ
import java.util.*;

public class Q1912 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int value[] = new int[num+1];
		
		for(int i=1; i<=num; i++)
			value[i] = sc.nextInt();
		
		continueSum(num, value);
	}
	void continueSum(int num, int[] value){
		int[] dp = new int[num+1];
		
		dp[1] = value[1];
		
		for(int i=2; i<=num; i++)
			dp[i] = Math.max(value[i], dp[i-1]+value[i]);
		int max = dp[1];
		for(int i=1; i<=num; i++)
			max = Math.max(dp[i], max);
		
		System.out.println(max);
	}
	public static void main(String[] args) {
		new Q1912().main();
	}

}
