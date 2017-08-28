package algorithm;
//타일 채우기
//pass!!!!!!!!!!!!!!!!!!
import java.util.*;

public class Q2133 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		tileNum(num);
	}
	void tileNum(int num){
		int dp[] = new int[num+1];
		
		if(num >= 2){
			dp[2] = 3;
			dp[4] = 11;
		}
		
		for(int i=6; i<=num; i+=2)
			dp[i] = dp[i-4]*2 + dp[i-2]*3;
		System.out.println(dp[num]);
		
	}
	public static void main(String[] args) {
		new Q2133().main();
	}

}
