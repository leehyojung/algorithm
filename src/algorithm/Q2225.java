package algorithm;

import java.util.*;

//�պ���
public class Q2225 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		//���� ���� N
		int count = sc.nextInt();	//��� ���ڷ� ������̳� K
		
		makeCount(count, num);
	}
	void makeCount(int count, int num){
		int dp[][] = new int[count+1][num+1];
		dp[0][0]=1;
		for(int i=1; i<=count; i++){
			for(int j=0; j<=num; j++){
				for(int a=0; a<=j; a++){
					dp[i][j] += dp[i-1][j-a];
					dp[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(dp[count][num]);
	}
	public static void main(String[] args) {
		new Q2225().main();
	}

}
