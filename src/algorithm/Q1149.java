package algorithm;
//rgb거리 스티커문제와 유사함
import java.util.*;

public class Q1149 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int color[][] = new int[num+1][4];
		
		for(int i=1; i<=num; i++){
			for(int j=1; j<=3; j++)
				color[i][j] = sc.nextInt();
		}
		
		minRgb(num, color);
	}
	void minRgb(int num, int[][] color){
		int dp[][] = new int[num+1][4];
		if(num==0)
			System.out.println("0");
		else{
			dp[1][1] = color[1][1];
			dp[1][2] = color[1][2];
			dp[1][3] = color[1][3];
			for(int i=2; i<=num; i++){
				dp[i][1] = Math.min(dp[i-1][2]+color[i][1], dp[i-1][3]+color[i][1]);
				dp[i][2] = Math.min(dp[i-1][1]+color[i][2], dp[i-1][3]+color[i][2]);
				dp[i][3] = Math.min(dp[i-1][1]+color[i][3], dp[i-1][2]+color[i][3]);
			}
		
			int result = 0;
			result = Math.min(dp[num][1], Math.min(dp[num][2], dp[num][3]));
			System.out.println(result);
		}
	}
	public static void main(String[] args) {
		new Q1149().init();
	}

}
