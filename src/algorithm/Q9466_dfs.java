package algorithm;

import java.util.*;

public class Q9466_dfs {
	int arr[];
	int check[];	//들어온 첫번째 정점 번호
	int order[];	//순서
	void init(){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test-->0){
			int student = sc.nextInt();
			arr = new int[student+1];
			check = new int[student+1];
			order = new int[student+1];
			for(int i=1; i<=student; i++){
				arr[i] = sc.nextInt();
			}
			int temp = 0;
			for(int i=1; i<=student; i++){
				if(check[i]==0)	temp += dfs(i, i, 1);
			}
			System.out.println(student - temp);
		}
	}
	private int dfs(int i, int first, int num) {
		if(check[i]!=0){
			if(first != check[i])	return 0;
			return num - order[i];
		}
		check[i] = first;
		order[i] = num;
		return	dfs(arr[i], first, num+1);
	}
	public static void main(String[] args) {
		new Q9466_dfs().init();
	}

}
