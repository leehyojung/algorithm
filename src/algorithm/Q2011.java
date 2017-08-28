package algorithm;

import java.util.*;

//¾ÏÈ£
public class Q2011 {
	void init(){
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		
		deCode(code);
	}
	void deCode(String code){
		int d[] = new int[code.length()+1];
		d[0] = 1;
		
		for(int i=1; i<=code.length(); i++){
			if(code.charAt(i-1) >= '1' && code.charAt(i-1) <= '9'){
				d[i] = (d[i]+d[i-1])%1000000;
			}
			if(i==1)
				continue;
			if(code.charAt(i-2)=='0')
				continue;
			if((code.charAt(i-2)-'0')*10 + code.charAt(i-1)-'0' <= 26 && (code.charAt(i-2)-'0')*10 + code.charAt(i-1)-'0' >= 10)
				d[i] = (d[i] + d[i-2])%1000000;
		}
		
		System.out.println(d[code.length()]);
	}
	public static void main(String[] args) {
		new Q2011().init();
	}

}
