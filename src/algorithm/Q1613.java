package algorithm;

import java.util.*;

//¿ª»ç
public class Q1613 {
	int spot;
	boolean check[];
	LinkedList<Integer>[] list;
	int x, y;
	void init(){
		Scanner sc = new Scanner(System.in);
		spot = sc.nextInt();
		int count = sc.nextInt();
		
		list = new LinkedList[spot+1];
		for(int i=1; i<=spot; i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=1; i<=count; i++){
			x = sc.nextInt();
			y = sc.nextInt();
			list[x].add(y);
		}
		int know = sc.nextInt();
		for(int i=1; i<=know; i++){
			x = sc.nextInt();
			y = sc.nextInt();
			check = new boolean[spot+1];
			if(history(x, y)){
				System.out.println("-1");
				check = new boolean[spot+1];
			}
			else{
				if(history(y, x))
					System.out.println("1");
				else
					System.out.println("0");
			}
		}
	}
	private boolean history(int f, int l) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(f);
		check[f] = true;
		while(!q.isEmpty()){
			int a = q.poll();
			for(int i: list[a]){
				if(i==l)	return true;
				if(check[i]==false){
					check[i] = true;
					q.add(i);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		new Q1613().init();
	}

}
