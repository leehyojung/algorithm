package algorithm;

import java.util.*;

public class Q9517 {
	int take;
	static final int limit = 210;
	int bombTime = 0;
	void init(){
		Scanner sc = new Scanner(System.in);
		take = sc.nextInt();
		int question = sc.nextInt();
		while(question-- > 0){
			int time = sc.nextInt();
			String answer = sc.next();
			bombTime += time;
			if(bombTime >= limit){
				System.out.println(take);
				return;
			}
			if(answer.equals("T")){
				if(take == 8)	take = 1;
				else	take++;
			}
		}
	}

//	private void bomb(int time, String answer) {
//		bombTime += time;
//		if(bombTime >= limit){
//			System.out.println(take);
//			return;
//		}
//		if(answer.equals("T")){
//			if(take == 8)	take = 1;
//			else	take++;
//		}
//	}

	public static void main(String[] args) {
		new Q9517().init();
	}

}
