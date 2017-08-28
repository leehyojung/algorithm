package algorithm;

import java.util.*;

//�ֻ��� ����
public class Q5566 {
	void init(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//�ֻ��� ��
		int m = sc.nextInt();	//����̰� �ֻ����� ���� Ƚ��
		
		int dn[] = new int[n+1];
		int dm[] = new int[m+1];
		
		for(int i=1; i<=n; i++)
			dn[i] = sc.nextInt();
		for(int i=1; i<=m; i++)
			dm[i] = sc.nextInt();
		
		System.out.println(howMany(n, m, dn, dm));
	}
	int howMany(int n, int m, int[] dn, int[] dm){
		int location = 1;
		int count = 1;
		
//		while(true){
//			location = location + dm[count];
//			if(location >= n)	break;
//			location = location + dn[location];
//			if(location >= n)	break;
//			count++;
//		}
		
		while(location < n){
			location += dm[count];
			if(location >= n) return count;
			location += dn[location];
			count++;
		}
		
		return count-1;
	}
	public static void main(String[] args) {
		new Q5566().init();
	}

}
