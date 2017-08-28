package algorithm;

import java.util.*;

public class Q1182 {
	int N, S;	//N = 정수의 갯수, S = 원하는 수
	int[] temp;
	int[] list;
	int result = 0;
	void init(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		list = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++){
			list[i] = sc.nextInt();
			if(list[i] == S)	result += 1;
			sum += list[i];
		}
		if(N > 1 && sum == S)	result += 1;
		for(int i=2; i<N; i++){
			temp = new int[i];
			combi(0, 0, i);
		}
		System.out.println(result);
	}
	private void combi(int i, int level, int count) {
		if(level == count){
			int sum = 0;
			for(int a=0; a<count; a++){
				sum += temp[a];
			}
			if(sum == S)	result += 1;
			return;
		}else if(i > N-1)	return;
		else{
			temp[level] = list[i];
			combi(i+1, level+1, count);
			combi(i+1, level, count);
		}
	}
	public static void main(String[] args) {
		new Q1182().init();
	}

}
