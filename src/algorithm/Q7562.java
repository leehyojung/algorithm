package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//나이트의 이동
public class Q7562 {
	int dx[] = {-2,-1,-2,-1,1,2,1,2};
	int dy[] = {-1,-2,1,2,-2,-1,2,1};
	int[][] check;
	int N, a, b, c, d;
	void init(){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test-->0){
			N = sc.nextInt();
			check = new int[N][N];
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			System.out.println(bfs());
		}
	}
	int bfs(){
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, b));	//현재 나이트의 위치
		check[a][b] = 1;
		while(!q.isEmpty()){
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0; i<8; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<N &&ny>=0 && ny<N){
					if(check[nx][ny]==0){
						check[nx][ny] = check[x][y] + 1;
						q.add(new Point(nx, ny));
						if(nx==c && ny==d)	return check[nx][ny]-1;
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		new Q7562().init();
	}

}
