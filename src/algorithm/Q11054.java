package algorithm;
//바이토닉 수열
import java.util.*;

public class Q11054 {
	void main(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int value[] = new int[num+1];
		for(int i=1; i<=num; i++){
			value[i] = sc.nextInt();
		}
		
		howLong(num, value);
	}
	void howLong(int num, int[] value){
		int incDp[] = new int[num+1];
		int decDp[] = new int[num+1];
		incDp[1] = 1;
		decDp[num] = 1;
		int result = 0;

		for(int i=2; i<=num; i++){
			for(int j=1; j<i; j++){	
				if(value[i] > value[j]){
					incDp[i] = Math.max(incDp[i], incDp[j]);
				}
			}
			incDp[i] = incDp[i]+1;
		}
		
		for(int i=num-1; i>=1; i--){
			for(int j=num; j>i; j--){	
				if(value[i] > value[j]){
					decDp[i] = Math.max(decDp[i], decDp[j]);
				}
			}
			decDp[i] = decDp[i]+1;
		}
		
		for(int i=1; i<=num; i++)
			result = Math.max(result, incDp[i]+decDp[i]-1);
		System.out.println(result);

	}
	public static void main(String[] args) {
		new Q11054().main();
	}

}
