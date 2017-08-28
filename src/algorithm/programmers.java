package algorithm;
import java.util.Scanner;

import javax.swing.border.Border;

public class programmers {
	static int N;
	static final int cnt = 5;
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] board = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		dfs(board, 0, -1);
		System.out.println(max);
	}
	static void dfs(int[][] board, int dir, int cnt) {
		int[][] new_board = new int[N+2][N+2];
		if(dir == 1) { //À§
			for(int i = 1; i < N+1; i++) { //x
				boolean[] visited = new boolean[N+2];
				int cursor = 1;
				for(int j = 1; j < N+1; j++) {
					if(board[j][i] != 0) {
						if(board[j][i] == new_board[cursor-1][i] && !visited[cursor-1]) {
							new_board[cursor-1][i] *= 2;
							visited[cursor-1] = true;
							max = Math.max(new_board[cursor-1][i], max);
						}
						else {
							new_board[cursor][i] = board[j][i];
							max = Math.max(new_board[cursor][i], max);
							cursor++;
						}
					}
				}
			}
		}
		else if(dir == 2) { //¾Æ·¡
			for(int i = 1; i < N+1; i++) { //x
				int cursor = N;
				boolean[] visited = new boolean[N+2];
				for(int j = N; j > 0; j--) {
					if(board[j][i] != 0) {
						if(board[j][i] == new_board[cursor+1][i] && !visited[cursor+1]) {
							new_board[cursor+1][i] *= 2;
							visited[cursor+1] = true;
							max = Math.max(new_board[cursor+1][i], max);
						}
						else {
							new_board[cursor][i] = board[j][i];
							max = Math.max(new_board[cursor][i], max);
							cursor--;
						}
					}
				}
			}
		}
		else if(dir == 3) { //ÁÂ
			for(int i = 1; i < N+1; i++) { //x
				int cursor = 1;
				boolean[] visited = new boolean[N+2];
				for(int j = 1; j < N+1; j++) {
					if(board[i][j] != 0) {
						if(board[i][j] == new_board[i][cursor-1] && !visited[cursor-1]) {
							new_board[i][cursor-1] *= 2;
							visited[cursor-1] = true;
							max = Math.max(new_board[i][cursor-1], max);
						}
						else {
							new_board[i][cursor] = board[i][j];
							max = Math.max(new_board[i][cursor], max);
							cursor++;
						}
					}
				}
			}
		}
		else if(dir == 4) { //¿ì
			for(int i = 1; i < N+1; i++) { //x
				int cursor = N;
				boolean[] visited = new boolean[N+2];
				for(int j = N; j > 0; j--) {
					if(board[i][j] != 0) {
						if(board[i][j] == new_board[i][cursor+1] && !visited[cursor+1]) {
							new_board[i][cursor+1] *= 2;
							visited[cursor+1] = true;
							max = Math.max(new_board[i][cursor+1], max);
						}
						else {
							new_board[i][cursor] = board[i][j];
							max = Math.max(new_board[i][cursor], max);
							cursor--;
						}
					}
				}
			}
		}
		if(++cnt == 5)
			return;
		for(int i = 1; i <= 4; i++) {
			if(dir == 0)
				dfs(board, i, cnt);
			else
				dfs(new_board, i, cnt);
		}
	}
}
