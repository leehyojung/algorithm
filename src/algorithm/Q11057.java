package algorithm;
//오르막 수
import java.util.*;

public class Q11057 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		ascend(num);
	}
	void ascend(int num){
		int d[][] = new int[num+1][10];
		
		for(int i=0; i<=9; i++)
			d[1][i] = 1;
		
		for(int i=2; i<=num; i++){
			for(int j=0; j<=9; j++){
				for(int a=0; a<=j; a++){
					d[i][j] += d[i-1][j-a];
					d[i][j] %= 10007;
				}
			}
		}
		long total=0;
		for(int i=0; i<=9; i++)
			total += d[num][i];
		System.out.println(total%10007);
	}
	public static void main(String[] args) {
		new Q11057().main();
	}

}
