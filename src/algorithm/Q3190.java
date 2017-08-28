package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;
//실패
public class Q3190 {
	int sec = 0;	//초
	int now = 1;	//방향
	void init(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int apple = sc.nextInt();
		int map[][] = new int[n][n];
		
		for(int i=0; i<apple; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
		}
		
		int turn = sc.nextInt();
		Queue tu = new LinkedList();
		for(int i=0; i<turn; i++){
			int a = sc.nextInt();
			String b = sc.next();
			tu.offer(a);
			tu.offer(b);
		}
		System.out.println(whatTime(n, map, tu));
	}
	
	int whatTime(int n, int[][] map, Queue tu) {
		Queue<Point> snake = new LinkedList<Point>();
		snake.offer(new Point(0,0));
		int a = 0, b = 0;
		
		while(true){
			Object second = sec;
			if (second == tu.peek()) {
				tu.poll();
				changeDirection(tu.poll().toString());
			}
			if (mapCheck(n, snake.peek().x, snake.peek().y)) {
				a = snake.peek().x;
				b = snake.peek().y;

				switch (now) {
				case (1):
					b += 1;
					break;
				case (2):
					a += 1;
					break;
				case (3):
					b -= 1;
					break;
				case (4):
					a -= 1;
					break;
				}
				int x = a;
				int y = b;
				for(int i=0; i<snake.size(); i++){
					if(snake.peek().x == x && snake.peek().y == y){
						sec++;
						return sec;
					}
					snake.offer(snake.poll());
				}
				snake.offer(new Point(a, b));
				
				if (map[a][b] == 1)	map[a][b] = 0;
				else snake.poll();
				sec++;
			}
			else
				return sec;	
		}
	}
	
	boolean mapCheck(int n, int x, int y) {
		switch(now){
		case(1):	y+=1;
		break;
		case(2):	x+=1;
		break;
		case(3):	y-=1;
		break;
		case(4):	x-=1;
		break;
		}
		if(x>=0 && y>=0 && x<n && y<n)
			return true;
		else{
			sec++;
			return false;
		}
	}

	void changeDirection(String a){
		switch(now){
		case(1) :
			if(a.equals("D"))	now=2;
			else	now=4;
		break;
		case(2) :
			if(a.equals("D"))	now=3;
			else	now=1;
		break;
		case(3) :
			if(a.equals("D"))	now=4;
			else	now=2;
		break;
		case(4) :
			if(a.equals("D"))	now=1;
			else	now=3;
		break;
		}
	}
	public static void main(String[] args) {
		new Q3190().init();
	}

}
