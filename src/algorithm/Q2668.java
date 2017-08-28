package algorithm;

import java.util.*;

public class Q2668 {
	int point[];
	int check[];
	int vertex[];
	int result = 0;

	void init() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		point = new int[num + 1];
		check = new int[num + 1];
		vertex = new int[num + 1];
		int same = 0;
		for (int i = 1; i <= num; i++) {
			point[i] = sc.nextInt();
			if(i==point[i]){
				check[i] = -1;
				result += 1;
			}
		}
		int temp = 0;
		for (int i = 1; i <= num; i++) {
			if (check[i] == 0) {
				result += bfs(i);
			}
		}
		System.out.println(result);
		for (int i = 1; i <= num; i++) {
			if (check[i] == -1 || vertex[i] != -2){
				System.out.println(i);
			}
		}
	}

	// point, check, vertex
	private int bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 1;
		int step = i;
		while (true) {
			if (check[i] != 0) {
				while(!q.isEmpty()){
					int x = q.poll();
					if(x == i)	break;
					vertex[x] = -2;
				}
				if (vertex[i] != step)
					return 0;
				return cnt - check[i];
			}
			q.add(i);
			check[i] = cnt;
			vertex[i] = step;
			i = point[i];
			cnt += 1;
		}
	}

	public static void main(String[] args) {
		new Q2668().init();
	}

}
