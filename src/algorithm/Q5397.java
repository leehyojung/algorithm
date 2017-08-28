package algorithm;

import java.util.*;

public class Q5397 {
	void init(){
		Scanner sc= new Scanner(System.in);
		int test = sc.nextInt();
		Stack<Character> st1;
		Stack<Character> st2;
		while(test-->0){
			String str = sc.next();
			st1 = new Stack<Character>();
			st2 = new Stack<Character>();
			for(int i=0; i<str.length(); i++){
				char ch = str.charAt(i);
				if(ch=='-'){
					if(st1.size()>=1)	st1.pop();
				}
				else if(ch=='<'){
					if(st1.size()>=1)	st2.push(st1.pop());
				}
				else if(ch=='>'){
					if(st2.size()>=1)	st1.push(st2.pop());
				}
				else{
					st1.push(ch);
				}
			}
			while(!st1.isEmpty()){
				st2.push(st1.pop());
			}
			while(!st2.isEmpty()){
				System.out.print(st2.pop());
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		new Q5397().init();
	}

}
