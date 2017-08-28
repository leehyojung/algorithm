package algorithm;

import java.io.*;
import java.util.*;

//ерга╥на╖ф╝
public class Q9466 {
	int list[];
	int check[];
	int point[];
	Queue<Integer> q;
	Queue<Integer> c;
	static StringTokenizer st;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int num = Integer.parseInt(br.readLine());
			list = new int[num + 1];
			check = new int[num + 1];
			point = new int[num + 1];
			st = new StringTokenizer(br.readLine());

			int result = 0;
			for (int i = 1; i <= num; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				if(list[i] == i){
					check[i] = -1;
					result+=1;
				}
			}
			
			for (int i = 1; i <= num; i++) {
				if (check[i] == 0) {
					result += bfs(i, i);
				}
			}
			System.out.println(num - result);
		}
	}

	private int bfs(int v, int step) {
		int cnt = 1;
		while(true){
			if(check[v] != 0){
				if(point[v] != step)	return 0;
				return cnt - check[v];
			}
			point[v] = step;
			check[v] = cnt;
			v = list[v];
			cnt += 1;
		}
	}
	public static void main(String[] args) throws IOException {
		new Q9466().init();
	}

}
