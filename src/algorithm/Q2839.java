package algorithm;

import java.util.*;

public class Q2839 {
	void init() {
		Scanner sc = new Scanner(System.in);
		int ki = sc.nextInt();
		
		if(ki % 5 == 0){
			System.out.println(ki/5);
			return;
		}
		
		int bong = ki / 5;
		while ((ki - 5 * bong) % 3 != 0 ) {
			bong--;
			if(bong == -1){
				System.out.println("-1");
				return;
			}
		}
		System.out.println(bong + (ki - 5 * bong) / 3);
	}

	public static void main(String[] args) {
		new Q2839().init();
	}

}
