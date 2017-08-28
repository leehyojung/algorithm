package algorithm;

import java.awt.*;
import java.util.*;

//좌표정렬하기
//시간초과
//2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
public class Q11650 {
	LinkedList<Point> list;

	void init() {
		Scanner sc = new Scanner(System.in);
		list = new LinkedList<Point>();
		int num = sc.nextInt();
		while (num-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Point(x, y));
		}
	}

	public static void main(String[] args) {
		new Q11650().init();
	}
}
