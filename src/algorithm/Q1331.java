package algorithm;

import java.util.*;

public class Q1331 {
	int dx[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
	int dy[] = { -1, 1, 2, 2, 1, -1, -2, -2 };
	boolean check[][];
	boolean ok = true;

	void init() {
		Scanner sc = new Scanner(System.in);
		int count = 36;
		check = new boolean[7][7];
		boolean ok = false;
		String temp = sc.next();
		int x = temp.charAt(0) - 'A' + 1;
		int y = temp.charAt(1) - '0';
		int firstx = x;
		int firsty = y;
		int lastx = x;
		int lasty = y;
		check[x][y] = true;
		while (count-- > 1) {
			temp = sc.next();
			x = temp.charAt(0) - 'A' + 1;
			y = temp.charAt(1) - '0';
			if (check[x][y]) {
				System.out.println("Invalid");
				return;
			}
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx == lastx && ny == lasty) {
					check[x][y] = true;
					lastx = x;
					lasty = y;
					cnt++;
				}
				if (count == 1 && nx == firstx && ny == firsty) {
					ok = true;
				}
			}
			if (cnt == 0) {
				System.out.println("Invalid");
				return;
			}
		}
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if (!check[i][j]) {
					System.out.println("Invalid");
					return;
				}
			}
		}
		System.out.println(ok == true ? "Valid" : "Invalid");
	}

	public static void main(String[] args) {
		new Q1331().init();
	}
}
