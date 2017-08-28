package algorithm;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] map = new int[5];
		int[] result = new int[5];
		map[0] = 1;
		map[1] = 2;
		map[2] = 3;
		result = map;
		for(int i=0; i<5; i++){
			System.out.println(result[i]);
		}
	}

}

