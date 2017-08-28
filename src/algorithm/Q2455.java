package algorithm;
//지능형 기차
import java.util.*;

public class Q2455 {
	void init(){
		int[][] people = new int[5][3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=4; i++)
			for(int j=1; j<=2; j++)
				people[i][j] = sc.nextInt();
		
		maxPeople(people);
	}
	void maxPeople(int[][] p){
		int max = p[1][2];
		int result = p[1][2];
		for(int i=2; i<=4; i++){
			if(result < max - p[i][1] + p[i][2]){
				result = max - p[i][1] + p[i][2];
			}
			max = max - p[i][1] + p[i][2];
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		new Q2455().init();
	}

}
