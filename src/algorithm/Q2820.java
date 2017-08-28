package algorithm;

import java.util.*;
//자동차공장, 시간초과, 세그먼트트리 사용해야함.
public class Q2820 {
	int check[];
	int pay[];
	LinkedList<Integer> list[];

	void init() {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int change = sc.nextInt();
		pay = new int[people + 1];
		pay[1] = sc.nextInt(); // 상근이 월급
		list = new LinkedList[people + 1];
		for (int i = 1; i <= people; i++) {
			list[i] = new LinkedList<Integer>();
		}
		//입력된 직원들을 방향 그래프로 만듦
		for (int i = 2; i <= people; i++) {
			pay[i] = sc.nextInt();
			int x = sc.nextInt();
			list[x].add(i);
		}
		while(change-->0){
			String s = sc.next();
			switch(s){
			case "p":
				int x = sc.nextInt();
				int y = sc.nextInt();
				check = new int[people + 1];
				dfs(x, y);
				break;
			case "u":
				int z = sc.nextInt();
				System.out.println(pay[z]);
				break;
			}
		}
	}

	private void dfs(int x, int y) {
		if(check[x]==1)	return;
		check[x] = 1;
		for(int i : list[x]){
			if(check[i]==0){
				pay[i] += y;
				dfs(i, y);
			}
		}
	}

	public static void main(String[] args) {
		new Q2820().init();
	}

}
