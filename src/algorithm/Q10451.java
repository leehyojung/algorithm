package algorithm;

import java.util.*;

public class Q10451 {
	ArrayList<Integer>[] a;
	boolean check[];
	void init(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while(num-->0){
			int n = sc.nextInt(); 	//Á¤Á¡ÀÇ °¹¼ö
			a = new ArrayList[n+1];
			check = new boolean[n+1];
			for(int i=1; i<=n; i++)
				a[i] = new ArrayList<Integer>();
			
			for(int i=1; i<=n; i++){
				int x = sc.nextInt();
				a[i].add(x);
				a[x].add(i);
			}
			int total=0;
			for(int i=1; i<=n; i++){
				if(check[i]==false){
					dfs(i);
					total++;	
				}
			}
			System.out.println(total);
		}
	}
	void dfs(int x) {
		if(check[x])
			return;
		check[x]=true;
		for(int i:a[x]){
			if(check[i]==false)
				dfs(i);
		}
	}
	public static void main(String[] args) {
		new Q10451().init();
	}

}
