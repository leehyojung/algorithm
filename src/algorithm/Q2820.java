package algorithm;

import java.util.*;
//�ڵ�������, �ð��ʰ�, ���׸�ƮƮ�� ����ؾ���.
public class Q2820 {
	int check[];
	int pay[];
	LinkedList<Integer> list[];

	void init() {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int change = sc.nextInt();
		pay = new int[people + 1];
		pay[1] = sc.nextInt(); // ����� ����
		list = new LinkedList[people + 1];
		for (int i = 1; i <= people; i++) {
			list[i] = new LinkedList<Integer>();
		}
		//�Էµ� �������� ���� �׷����� ����
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
