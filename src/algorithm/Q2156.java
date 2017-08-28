package algorithm;

import java.util.*;

//포도주 시식
public class Q2156 {
	Scanner sc = new Scanner(System.in);
	void main(){
		int num = sc.nextInt();
		
		manyGrape(num);
	}
	void manyGrape(int num){
		int dp[] = new int[num+1];
		int amount[] = new int[num+1];
		
		for(int i=1; i<=num; i++)
			amount[i] = sc.nextInt();
		
		dp[1] = amount[1];
		if(num>=2)
			dp[2] = dp[1] + amount[2];
		
		for(int i=3; i<=num; i++){
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+amount[i], dp[i-3]+amount[i-1]+amount[i]));
		}
		System.out.println(dp[num]);
	}
	public static void main(String[] args) {
		new Q2156().main();		
	}

}
