package algorithm;

import java.util.*;

//¸·´ë±â
public class Q1049 {
	void init(){
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(howMany(num));
	}
	int howMany(int num){
		int length=64;
		int want=0;
		int num2 = num;
		int count=0;
		
		while(want!=num2){
			while(length > num){
				length /= 2;
			}
			want += length;
			num -= length;
			count++;
		}
		
		return count;
	}
	public static void main(String[] args) {
		new Q1049().init();
	}

}
