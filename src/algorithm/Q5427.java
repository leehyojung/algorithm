package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//'.': 빈 공간
//'#': 벽
//'@': 상근이의 시작 위치
//'*': 불
//너비 w와 높이 h -> map[h][w];

//상근이 먼저, 그다음 불
//시간초과

public class Q5427 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int W, H;
	char map[][];
	int check[][];
	int Scount = 0;
	Queue<Point> S;	//상근
	Queue<Point> F;	//불
	void init(){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test-->0){
			W = sc.nextInt();
			H = sc.nextInt();
			map = new char[H+1][W+1];
			check = new int[H+1][W+1];
			S = new LinkedList<Point>();
			F = new LinkedList<Point>();
			for(int i = 1; i <= H; i++){
				String str = sc.next();
				for(int j = 1; j <= W; j++){
					map[i][j] = str.charAt(j-1);
					if(map[i][j]=='@'){
						S.add(new Point(i, j));
						check[i][j] = 1;
						Scount += 1;
					}
					else if(map[i][j] == '*'){
						F.add(new Point(i, j));
					}
				}
			}
			int result = escape();
			System.out.println(result==0?"IMPOSSIBLE": result);
		}
	}
	private int escape() {
		while(!S.isEmpty()){
			//move 상근	
			int Ss = S.size();
			int count = 0;
			for(int k = 0 ; k < Ss; k++){
				Point x = S.poll();
				if(map[x.x][x.y]=='*')	continue;
				for(int i = 0; i < 4; i++){
					int na = x.x + dx[i];
					int nb = x.y + dy[i];
					if(na > 0 && na <= H && nb > 0 && nb <= W){
						if(map[na][nb]=='.' && check[na][nb]==0){
							map[na][nb] = '@';
							check[na][nb] = check[x.x][x.y] + 1;
							count += 1;
							Scount += 1;
							S.add(new Point(na, nb));
						}
					}
					else	return check[x.x][x.y];
					map[x.x][x.y] = '.';
				}
			}
			if(count == 0 )	return 0;
			
			System.out.println("성근 후");
			for(int i = 1; i <= H; i++){
				for(int j = 1; j <= W; j++){
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}System.out.println();
			
			//move fire
			int Fs = F.size();
			for(int k = 0 ; k < Fs; k++){
				Point x = F.poll();
				for(int i = 0; i < 4; i++){
					int na = x.x + dx[i];
					int nb = x.y + dy[i];
					if(na > 0 && na <= H && nb > 0 && nb <= W){
						if(map[na][nb]!='#'){
							if(map[na][nb]!='@')	Scount -= 1;
							map[na][nb] = '*';
							F.add(new Point(na, nb));
						}
					}
				}
			}
			if(Scount == 0 )	return 0;
			
			System.out.println("불 후");
			for(int i = 1; i <= H; i++){
				for(int j = 1; j <= W; j++){
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}System.out.println();
			
		}
		return 0;
	}
	public static void main(String[] args) {
		new Q5427().init();
	}
}
