package algorithm;

import java.util.*;

public class Q5014 {
	Scanner sc = new Scanner(System.in);
	int F, S, G, U, D;
	int check[];

	int init() {
		F = sc.nextInt(); // ÃÑ Ãþ¼ö
		S = sc.nextInt(); // °­È£°¡ À§Ä¡ÇÑ Ãþ
		G = sc.nextInt(); // °¡°í½ÍÀº Ãþ
		U = sc.nextInt(); // UP
		D = sc.nextInt(); // DOWN
		
		if(S==G){
			System.out.println("0");
			return 0;
		}
			
		System.out.println(bfs()==0?"use the stairs":bfs()-1);
		return 0;
	}

	private int bfs() {
		check = new int[F + 1];
		check[S] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		while (!q.isEmpty()) {
			int x = q.poll();
			int a = x + U;
			int b = x - D;
			
			if (a > 0 && a <= F) {
				if (check[a] == 0) {
					q.add(a);
					check[a] = check[x] + 1;
				}
				if(a==G)
					return check[a];
			}
			if (b > 0 && b <= F) {
				if (check[b] == 0) {
					q.add(b);
					check[b] = check[x] + 1;
				}
				if(b==G)
					return check[b];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		new Q5014().init();
	}

}
