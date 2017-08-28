package algorithm;

import java.util.*;

public class Q11945 {
	int n, m;
	int init(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int fish[][] = new int[n][m];
		if(n==0 || m==0)	return 0;
		for(int i=0; i<n; i++){
			String str = sc.next();
			for(int j=0; j<m; j++){
				fish[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=m-1; j>=0; j--){
				System.out.print(fish[i][j]);
			}
			System.out.println(" ");
		}
		return 0;
	}
	public static void main(String[] args) {
		new Q11945().init();
	}

}
