package algorithm;

import java.awt.*;
import java.util.*;

//»ó¹üºôµù
public class Q6593 {
	class Spot {
		int a, b, c;

		Spot(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	int df[] = { 0, 0, 0, 0, 1, -1 };
	int dx[] = { -1, 0, 1, 0, 0, 0 };
	int dy[] = { 0, 1, 0, -1, 0, 0 };
	char map[][][];
	int check[][][];
	int x, y, z;
	Queue<Spot> q;

	void init() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		while (x != 0 && y != 0 && z != 0) {
			map = new char[x + 1][y + 1][z + 1];
			check = new int[x + 1][y + 1][z + 1];
			q = new LinkedList<Spot>();
			for (int a = 1; a <= x; a++) {
				for (int b = 1; b <= y; b++) {
					String str = sc.next();
					for (int c = 1; c <= z; c++) {
						map[a][b][c] = str.charAt(c - 1);
						if (map[a][b][c] == 'S') {
							q.add(new Spot(a, b, c));
							check[a][b][c] = 1;
						}
					}
				}
			}
			bfs();
			x = sc.nextInt();
			y = sc.nextInt();
			z = sc.nextInt();
		}

	}

	private void bfs() {
		while (!q.isEmpty()) {
			Spot s = q.poll();
			for (int i = 0; i < 6; i++) {
				int nf = s.a + df[i];
				int nx = s.b + dx[i];
				int ny = s.c + dy[i];
				if (nf > 0 && nf <= x && nx > 0 && nx <= y && ny > 0 && ny <= z) {
					if (check[nf][nx][ny] == 0 && map[nf][nx][ny] == '.') {
						check[nf][nx][ny] = check[s.a][s.b][s.c] + 1;
						q.add(new Spot(nf, nx, ny));
					}
					if (map[nf][nx][ny] == 'E') {
						System.out.println("Escaped in " + check[s.a][s.b][s.c] + " minute(s).");
						return;
					}
				}
			}
		}
		System.out.println("Trapped!");
		return;
	}

	public static void main(String[] args) {
		new Q6593().init();
	}

}
