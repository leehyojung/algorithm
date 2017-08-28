package algorithm;

import java.util.*;

//1로 만들기
public class Q1463 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int one[] = new int[num+1];
		System.out.println(makeone(num, one));
	}
	
	int makeone(int num, int[] one) {
		if(num<=3){
			one[num] = 1;
			one[1]=0;
		}
		else if(one[num]==0){
			if(num%3==0)
				one[num] = Math.min(makeone(num/3, one)+1, makeone(num-1, one)+1);
			else if(num%2==0)
				one[num] = Math.min(makeone(num/2, one)+1, makeone(num-1, one)+1);
			else
				one[num] = makeone(num-1, one)+1;
		}
		return one[num];
		
	}

	public static void main(String[] args) {
		new Q1463().main();
	}
}
