package algorithm;

import java.util.*;

//ÀÌÄ£¼ö
public class Q2193 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		zerone(num);
	}
	void zerone(int num){
		long d[][]=new long[num+1][2];
		d[1][0] = 0;
		d[1][1] = 1;
		
		for(int i=2; i<=num; i++){
			d[i][1] = d[i-1][0];
			d[i][0] = d[i-1][0] + d[i-1][1];
		}
		System.out.println(d[num][1] + d[num][0]);
	}
	public static void main(String[] args) {
		new Q2193().main();
	}

}
