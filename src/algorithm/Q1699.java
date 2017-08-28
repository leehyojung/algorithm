package algorithm;
//제곱근의 수
import java.util.*;

public class Q1699 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		squareMin(num);
		
	}
	void squareMin(int num){
		int dp[] = new int[num+1];

		for(int i=1; i<=num; i++)
			dp[i] = i;
		
		for(int i=3; i<=num; i++){
			for(int j=1; j*j<=i; j++){
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[num]);
	}
	public static void main(String[] args) {
		new Q1699().main();
	}
}
