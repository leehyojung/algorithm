package algorithm;

import java.util.*;

public class Q11727 {
		void main(){
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			int tile[] = new int[num+1];
			
			System.out.println(tileling(num, tile));
		}
		
		int tileling(int num, int[] tile) {
			if(num<=1)
				tile[num]=1;
			else if(tile[num]==0){
				tile[num] = (tileling(num-1, tile) + (tileling(num-2, tile))*2)%10007;
			}
			
			return tile[num];
		}

		public static void main(String[] args) {
			new Q11727().main();
		}
}

