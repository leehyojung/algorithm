package algorithm;

import java.util.*;

public class Q1120 {
	void init(){
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int a = B.length()-A.length()+1;
		
		int count = 0;
		int min = 50;
		do{
			int find = 0;
			for(int i=0; i<A.length(); i++){
				if(A.charAt(i) != B.charAt(i+count))	find++;
			}
			count++;
			min = Math.min(min, find);
		}while(count!=a);
		
		System.out.println(min);
		
	}
	public static void main(String[] args) {
		new Q1120().init();
	}

}
