package algorithm;

import java.util.*;

public class Q2331 {
	int check[];
	int cnt;
	void init(){
		Scanner sc = new Scanner(System.in);
		check = new int[1000000];
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(length(x, y, 1));
	}
	int length(int x, int y, int cnt){
		if(check[x]!=0){
			return check[x]-1; 
		}
		check[x] = cnt;
		int ne = next(x, y);
		return length(ne, y, cnt+=1);
	}
	int next(int x, int y){
		int ans = 0;
		while(x>0){
			ans += Math.pow(x%10, y);
			x /= 10;
		}
		return ans;
	}
	public static void main(String[] args) {
		new Q2331().init();
	}

}
