package algorithm;

import java.util.*;

public class Q2161 {
	Scanner sc = new Scanner(System.in);
	void init(){
		Queue card = new LinkedList();
		int num = sc.nextInt();
		numorder(card, num);
	}
	void numorder(Queue card, int num){
		for(int i=1; i<=num; i++)
			card.offer(i);
		
		while(card.peek()!=null){
			System.out.println(card.poll());
			card.offer(card.poll());
		}
	}
	public static void main(String[] args) {
		new Q2161().init();
	}
}
