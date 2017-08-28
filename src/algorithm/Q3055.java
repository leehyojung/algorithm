package algorithm;

import java.awt.*;
import java.util.*;
import java.util.Queue;

//Å»Ãâ, Æ¼¶·¼ü ºñ¹öÀÇ ±¼·Î~~
//°í½¿µµÄ¡ ¸ÕÀú ÀÌµ¿ -> ¹° ÀÌµ¿
public class Q3055 {
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { 1, -1, 0, 0 };
	int N, M;
	char map[][];
	int check[][];
	Queue<Point> S; // °í½¿µµÂ÷
	Queue<Point> W; // ¹°
	int countS = 1;
	int x, y;

	void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N + 1][M + 1];
		check = new int[N + 1][M + 1];
		S = new LinkedList<Point>();
		W = new LinkedList<Point>();
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j + 1] = str.charAt(j);
				if (map[i][j + 1] == 'S') {
					S.add(new Point(i, j + 1));
					check[i][j + 1] = 1;
				} else if (map[i][j + 1] == '*')
					W.add(new Point(i, j + 1));
				else if (map[i][j + 1] == 'D') {
					x = i;
					y = j + 1;
				}
			}
		}
		System.out.println(findCave() == 0 ? "KAKTUS" : check[x][y]-1);
	}

	private int findCave() {

		while (!S.isEmpty()) {
			// °í½¿µµÄ¡ ÀÌµ¿

			int Ss = S.size();
			int count = 0;
			for (int k = 0; k < Ss; k++) {
				int a = S.peek().x;
				int b = S.peek().y;
				S.poll();
				if(map[a][b]=='*'){
					countS -= 1;
					continue;
				}
				for (int i = 0; i < 4; i++) {
					int na = a + dx[i];
					int nb = b + dy[i];
					if (na > 0 && na <= N && nb > 0 && nb <= M) {
						if (map[na][nb] == 'D'){
							check[na][nb] = check[a][b] + 1;
							return check[na][nb];
						}
						else if (map[na][nb] == '.') {
							map[na][nb] = 'S';
							check[na][nb] = check[a][b] + 1;
							count += 1;
							countS += 1;
							S.add(new Point(na, nb));
						}
					}
				}
				map[a][b] = '.';
				countS -= 1;
			}
			if (count == 0)
				return 0;

			int Ws = W.size();
			for (int k = 0; k < Ws; k++) {
				// ¹° È®Àå
				int c = W.peek().x;
				int d = W.peek().y;
				W.poll();
				for (int i = 0; i < 4; i++) {
					int nc = c + dx[i];
					int nd = d + dy[i];
					if (nc > 0 && nc <= N && nd > 0 && nd <= M) {
						if (map[nc][nd] == '.' || map[nc][nd] == 'S') {
							map[nc][nd] = '*';
							W.add(new Point(nc, nd));
						}
					}
				}
				if (countS == 0)
					return 0;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		new Q3055().init();
	}

}
