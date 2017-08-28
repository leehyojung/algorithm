package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;
//�ٸ������
//Ʋ�Ƚ��ϴ�
public class Q2146 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int map[][];
	int check[][];
	Queue<Point> q;
	int init(){
		map = new int[n+1][n+1];
		check = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		//�� ��ȣ ���̱�
		int cnt = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(map[i][j]!=0 && check[i][j]==0){
					numbering(i, j, ++cnt);
				}
			}
		}
		
//		System.out.println("��ȣ���� map");
//		for(int i=1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("��ȣ���� check");
//		for(int i=1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(check[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
		
		if(cnt<=1){
			System.out.println("0");
			return 0;
		}
		//�� �ø��� �Ÿ� ����
		//map�� 0�� �ƴѰ͵� q�� �ְ�
		q = new LinkedList<Point>();
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(map[i][j]!=0){
					q.add(new Point(i, j));
				}
			}
		}
		bfs();
//		System.out.println("bfs�� map");
//		for(int i=1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("bfs�� check");
//		for(int i=1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(check[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
		int min = 100;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				for(int a=0; a<4; a++){
					int nx = i + dx[a];
					int ny = j + dy[a];
					if(nx > 0 && nx <= n && ny > 0 && ny <= n){
						if(map[nx][ny] != map[i][j]){
							min = Math.min(min, check[i][j] + check[nx][ny]);
						}
					}
				}
			}
		}
		System.out.println(min-2);
		return 0;
	}
	private void bfs() {
		while(!q.isEmpty()){
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int a=0; a<4; a++){
				int nx = x + dx[a];
				int ny = y + dy[a];
				if(nx > 0 && nx <= n && ny > 0 && ny <= n){
					if(map[nx][ny] == 0){
						map[nx][ny] = map[x][y];
						check[nx][ny] = check[x][y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	//numbering map and all check make 1.
	private void numbering(int i, int j, int cnt) {
		q = new LinkedList<Point>();
		q.add(new Point(i, j));
		map[i][j] = cnt;
		check[i][j] = 1;
		while(!q.isEmpty()){
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int a=0; a<4; a++){
				int nx = x + dx[a];
				int ny = y + dy[a];
				if(nx > 0 && nx <= n && ny > 0 && ny <= n){
					if(map[nx][ny] == 1 && check[nx][ny] == 0){
						map[nx][ny] = cnt;
						check[nx][ny] = 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Q2146().init();
	}

}
