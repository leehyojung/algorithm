package algorithm;

import java.util.*;

public class Q14501 {
	int day;
	int[] pay;
	int[] term;
	
	boolean[]check;
	int[] max;
	void init(){
		Scanner sc = new Scanner(System.in);
		day = sc.nextInt();
		pay = new int[day+1];
		term = new int[day+1];
		
		max = new int[day+1];
		check = new boolean[day+1];
		
		for(int i = 1; i<=day; i++){
			term[i] = sc.nextInt();
			pay[i] = sc.nextInt();
			if(i + term[i] > day+1)	check[i] = true;
		}
		
		for(int i = day; i>=1; i--){
			if(check[i]==false){
				max[i] = pay[i];
				for(int j = i+term[i]; j<=day; j++){
					max[i] = Math.max(max[i], pay[i] + max[j]);
				}
			}
		}
		int result = 0;
		for(int i = 1; i<=day; i++){
			if(check[i]==false)	result = Math.max(result, max[i]);
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		new Q14501().init();
	}

}
