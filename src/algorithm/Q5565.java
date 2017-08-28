package algorithm;

import java.util.*;

public class Q5565 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		for(int i=0; i<9; i++){
			x -= sc.nextInt();
		}
		System.out.println(x);
	}
	public static void main(String[] args) {
		new Q5565().init();
	}

}
