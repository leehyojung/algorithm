package algorithm;

import java.util.*;

public class Q1966 {
	Scanner sc = new Scanner(System.in);
	void init(){
		int num = sc.nextInt();
		for(int i=0; i<num; i++){
			int su = sc.nextInt();	//문서의 갯수
			int wonder = sc.nextInt();	//궁금한 문서의 위치
		
			System.out.println(important(su, wonder));
		}
	}
	int important(int su, int wonder){
		
		LinkedList<Integer> docu = new LinkedList<Integer>();
		LinkedList<Integer> pr = new LinkedList<Integer>();
		for(int i=0; i<su; i++){
			docu.add(sc.nextInt());
			pr.add(i);
		}
		
		int count = 0;
		int max = docu.get(0);
		for(int i=1; i<su; i++)
			if(max<docu.get(i))	max = docu.get(i);
		
		if(su==1)
			return 1;
		
		while(su!=0){
			while(docu.get(0)!=max){
				docu.add(docu.remove(0));
				pr.add(pr.remove(0));
			}
			count++;
			docu.remove(0);
			if(wonder == pr.remove(0))
				return count;
			su--;
			max = 0;
			for(int i=0; i<su; i++)
				if(max<docu.get(i))	max = docu.get(i);
		}
		return 0;
		
	}
	public static void main(String[] args) {
		new Q1966().init();
	}

}
