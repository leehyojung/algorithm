package algorithm;

import java.util.*;

public class Q13458 {
	void init(){
		Scanner sc = new Scanner(System.in);
		
		int examRoom = sc.nextInt();
		int person[] = new int[examRoom];
		for(int i=0; i<examRoom; i++){
			person[i] = sc.nextInt();
		}
		int superVisor = sc.nextInt();
		int subVisor = sc.nextInt();
		
		howMany(examRoom, person, superVisor, subVisor);
	}
	void howMany(int examRoom, int[] person, int superVisor, int subVisor) {
		long total=examRoom;
		
		for(int i=0; i<examRoom; i++){
			if(person[i]-superVisor <= 0);
			else{
				if((person[i]-superVisor)%subVisor ==0)
					total = total + (person[i]-superVisor)/subVisor;
				else
					total = total + (person[i]-superVisor)/subVisor + 1;
			}
			
		}
		System.out.println(total);
	}
	public static void main(String[] args) {
		new Q13458().init();
	}

}
