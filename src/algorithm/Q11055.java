package algorithm;
//가장 큰 증가하는 부분수열의 합
import java.util.*;

public class Q11055 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] a = new int[num+1];
		for(int i=1; i<=num; i++)
			a[i] = sc.nextInt();
		getFirstSum(num, a);
	}
	void getFirstSum(int num, int value[]){
		int dp[] = new int[num+1]; //i가 마지막인 부분수열
		int sum[] = new int[num+1]; //i가 마지막인 부분수열의 합
		dp[1] = 1;
		sum[1] = value[1];
		
		for(int i=2; i<=num; i++){
			for(int j=1; j<i; j++){
				if(value[i] > value[j]){
					sum[i] = Math.max(sum[i], sum[j]);
				}
			}
			sum[i] += value[i];
		}
		int total=0;
		for(int i=1; i<=num; i++)
			total = Math.max(total, sum[i]);
		System.out.println(total);
	}
	public static void main(String[] args) {
		new Q11055().main();
	}

}
