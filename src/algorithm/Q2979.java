package algorithm;

import java.util.*;

public class Q2979 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int max = 0;
		int check[] = new int[101];
		for(int i=0; i<3; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			max = Math.max(max, y);
			for(int j=x; j<y; j++){
				check[j]++;
			}
		}
		int result = 0;
		for(int i = 1; i<=max; i++){
			if(check[i]==1)
				result += A;
			else if(check[i]==2)
				result += (B*2);
			else if(check[i]==3)
				result += (C*3);
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		 new Q2979().init();
	}

}
