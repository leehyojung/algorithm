package algorithm;

import java.awt.*;
import java.util.*;

//��ǥ�����ϱ�
//�ð��ʰ�
//2���� ��� ���� �� N���� �־�����. ��ǥ�� x��ǥ�� �����ϴ� ������, x��ǥ�� ������ y��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
