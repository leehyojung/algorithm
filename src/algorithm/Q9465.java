package algorithm;
//½ºÆ¼Ä¿
import java.util.*;

public class Q9465 {
	Scanner sc = new Scanner(System.in);
	void main(){
		int num = sc.nextInt();
		int count[] = new int[num];
		
		for(int a=0; a<num; a++){
			count[a] = sc.nextInt();
			
			mostBig(count[a]);
		}
	}
	void mostBig(int num){
		int stiker[][] = new int[3][num+1];
		for(int i=1; i<=2; i++){
			for(int j=1; j<=num; j++){
				stiker[i][j] = sc.nextInt();
			}
		}
		int d[][] = new int[num+1][3];
		d[1][0] = stiker[1][1]; 
		d[1][1] = stiker[2][1];
		d[1][2] = 0;
		for(int i=2; i<=num; i++){
			//d[i][2] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1]+stiker[1][i], d[i-1][2]+stiker[1][i]));
			d[i][1] = Math.max(d[i-1][1], Math.max(d[i-1][0]+stiker[2][i], d[i-1][2]+stiker[2][i]));
			}
		int total = Math.max(d[num][0], Math.max(d[num][1], d[num][2]));
		System.out.println(total);
	}
	public static void main(String[] args) {
		new Q9465().main();
	}

}
