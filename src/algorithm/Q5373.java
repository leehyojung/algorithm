package algorithm;
//ÃÊ±â °ª 0:B 1:U 2:F 3:D 4:L 5:R

import java.util.*;

public class Q5373 {
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	char[][][] map = new char[6][3][3];
	void init(){
		
		for(int a=0; a<6; a++){
			for(int b=0; b<3; b++){
				for(int c=0; c<3; c++){
					switch(a){
					case 0:
						map[a][b][c] = 'o';
						break;
					case 1:
						map[a][b][c] = 'w';
						break;
					case 2:
						map[a][b][c] = 'r';
						break;
					case 3:
						map[a][b][c] = 'y';
						break;
					case 4:
						map[a][b][c] = 'g';
						break;
					case 5:
						map[a][b][c] = 'b';
						break;
					}
				}
			}
		}
		sc.nextLine();
		for(int i=0; i<num; i++){
			String s = sc.next();
			char order = s.charAt(0);
			char pm = s.charAt(1);
			changeCube(order, pm, map);
			
			for (int z = 0; z < 6; z++) {
				System.out.println(z);
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						System.out.printf(map[z][a][b] + " ");
					}
					System.out.println(" ");
				}
			}
		}
	}
	void changeCube(char order, char pm, char[][][] map){
		int a=0, b=0, c=0, d=0;
		switch(order){
		case 'B':
			a=3; b=4; c=1; d=5;
			break;
		case 'U':
			a=0; b=4; c=2; d=5;
			break;
		case 'F':
			a=1; b=4; c=3; d=5;
			break;
		case 'D':
			a=2; b=4; c=0; d=5;
			break;
		case 'L':
			a=0; b=3; c=2; d=1;
			break;
		case 'R':
			a=0; b=1; c=2; d=3;
			break;
		}
		switch(pm){
		case '-':
			char temp1 = map[a][2][0], temp2=map[a][2][1], temp3=map[a][2][2];
			map[a][2][0]=map[d][0][0];map[a][2][1]=map[d][1][0];map[a][2][2]=map[d][2][0];
			map[d][0][0]=map[c][0][2];map[d][1][0]=map[c][0][1];map[d][2][0]=map[c][0][0];
			map[c][0][0]=map[b][0][2];map[c][0][1]=map[b][1][2];map[c][0][2]=map[b][2][2];
			map[b][0][2]=temp3;map[b][1][2]=temp2;map[b][2][2]=temp1;
			break;
		case '+':
			char temp4 = map[a][2][0], temp5=map[a][2][1], temp6=map[a][2][2];
			map[a][2][0]=map[b][2][2];map[a][2][1]=map[b][1][2];map[a][2][2]=map[b][0][2];
			map[b][0][2]=map[c][0][0];map[b][1][2]=map[c][0][1];map[b][2][2]=map[c][0][2];
			map[c][0][0]=map[d][2][0];map[c][0][1]=map[d][1][0];map[c][0][2]=map[d][0][0];
			map[d][0][0]=temp4;map[d][1][0]=temp5;map[d][2][0]=temp6;
			break;
		}
		
	}
	public static void main(String[] args) {
		new Q5373().init();
	}

}
