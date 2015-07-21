package com.myIbatis.test;

public class DiguiTest {
	static int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

	/**
	 * 关于递归的测试，测试看看当递归进下一层调用后，原来的层中的数据数据是否已经变化
	 */
	public static void main(String[] args) {

		int b[] = a.clone();
		test(0);
		System.out.println("\n外层的b数组：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	private static void test(int i) {
		int b[] = a;
		if (i <= 7) {
			b[i]++;
			i++;
			test(i);
		} else {
			System.out.println("内层的a数组：");
			for (int ii = 0; ii < b.length; ii++) {
				System.out.print(b[ii] + " ");
			}
		}
	}

}
