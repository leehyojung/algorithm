package algorithm;

import java.util.*;
//쉬운계단수
public class Q10844 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		staircount(num);
	}
	
	void staircount(int num) {
		int stair[][] = new int[num+1][10];
		
		for(int i=1; i<=9; i++)
			stair[1][i] = 1;
		
		for(int i=2; i<=num; i++){
			for(int j=0; j<=9; j++){
				if(j-1 >= 0)
					stair[i][j] += stair[i-1][j-1];
				if(j+1 <= 9)
					stair[i][j] += stair[i-1][j+1];
				stair[i][j] %= 1000000000;
			}
		}
		
		long ans =0;
		for(int i=0; i<=9; i++)
			ans += stair[num][i];
		System.out.println(ans%1000000000);
	}

	public static void main(String[] args) {
		new Q10844().main();
	}

}
