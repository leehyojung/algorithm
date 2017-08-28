package algorithm;

import java.util.*;

//ºØ¾î»§ ¸¸µé±â
public class Q11052 {

	void main(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();	//ºØ¾î»§ °¹¼ö
		int pay[] = new int[count+1];	//ºØ¾î»§ ¼ÂÆ® ´ç °¡°Ý
		int maxpay[] = new int[count+1];
		for(int i=1; i<=count; i++){
			pay[i] = sc.nextInt();
		}
		System.out.println(maxprice(count, pay, maxpay));
		
	}
	int maxprice(int count, int[] pay, int[] maxpay) {
		maxpay[count] = pay[count];
		for(int i=1; i<count; i++){
			if(maxpay[count] <= maxprice(count-i, pay, maxpay) + pay[i])
				maxpay[count] = Math.max(maxpay[count], maxprice(count-i, pay, maxpay) + pay[i]);
		}
//		for(int i=1; i<=count; i++){
//			for(int j=1; j<=i; j++)
//				maxpay[i] = Math.max(maxpay[i], maxpay[i-1] + pay[j]);
//		}
		
		return maxpay[count];
	}
	public static void main(String[] args) {
		new Q11052().main();

	}

}
