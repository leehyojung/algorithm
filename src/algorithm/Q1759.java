package algorithm;

import java.util.*;

//backtracking 암호만들기, 로또와 유사한 문제
public class Q1759 {
	int max;
	int alpa;
	char[] code;
	char[] temp;

	void init() {
		Scanner sc = new Scanner(System.in);
		max = sc.nextInt();
		alpa = sc.nextInt();
		code = new char[alpa];
		temp = new char[max];
		for (int i = 0; i < alpa; i++) {
			code[i] = sc.next().charAt(0);
		}
		Arrays.sort(code);
		combi(0, 0);
	}

	private void combi(int i, int j) {
		if (j == max) {
			// 자음 모음
			int count = 0;
			for (int k = 0; k < max; k++) {
				if (temp[k] == 'a' || temp[k] == 'e' || temp[k] == 'i' || temp[k] == 'o' || temp[k] == 'u')
					count++;
			}
			if (count > 0 && max - count > 1) {
				for (int k = 0; k < max; k++) {
					System.out.print(temp[k]);
				}
				System.out.println();
			}
			return;
		} else if (i >= alpa)
			return;
		else {
			temp[j] = code[i];
			combi(i + 1, j + 1);
			combi(i + 1, j);
		}
	}

	public static void main(String[] args) {
		new Q1759().init();
	}

}
