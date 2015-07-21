package com.myIbatis.test;

public class EightQueen {

	// public static void main(String[] args) {
	// for(int i1=0;i1<8;i1++){
	// char[][] x= {{'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'},
	// {'0','0','0','0','0','0','0','0'}};
	// x[i1][0] = '1';
	// for(int i2=0;i2<8;i2++){
	// if(check(1,x,i2)==0)
	// continue;
	// else{
	// x[i2][1] = '1';
	// for(int i3=0;i3<8;i3++){
	// if(check(2,x,i3)==0)
	// continue;
	// else{
	// x[i3][2]='1';
	// for(int i4=0;i4<8;i4++){
	// if(check(3,x,i4)==0)
	// continue;
	// else{
	// x[i4][3]='1';
	// for(int i5=0;i5<8;i5++){
	// if(check(4,x,i5)==0)
	// continue;
	// else{
	// x[i5][4]='1';
	// for(int i6=0;i6<8;i6++){
	// if(check(5,x,i6)==0)
	// continue;
	// else{
	// x[i6][5]='1';
	// for(int i7=0;i7<8;i7++){
	// if(check(6,x,i7)==0)
	// continue;
	// else{
	// x[i7][6]='1';
	// for(int i8=0;i8<8;i8++){
	// if(check(7,x,i8)==0)
	// continue;
	// else{
	// x[i8][7]='1';
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// continue;
	// }
	// }
	// show(x);
	// }
	// }
	//
	// public static int check(int y, char[][] arr, int x){
	// //先判断横向是否合适，看横向x坐标定，y循环
	// for(int i=0;i<8;i++){
	// if('1' == arr[x][i])
	// return 0;
	// }
	// //再判断纵向是否合适，看纵向y坐标定，x循环
	// for(int i=0;i<8;i++){
	// if('1' == arr[i][y])
	// return 0;
	// }
	// //再判断'\'方向对角线是否合适，看纵向y坐标定，x循环
	// for(int i=0;i<8;i++){
	// if(x-i >= 0 && y+i <= 7){
	// if('1' == arr[x-i][y+i])
	// return 0;
	// }
	// if(x+i <= 7 && y-i >= 0){
	// if('1' == arr[x+i][y-i])
	// return 0;
	// }
	// }
	// //再判断'/'方向对角线是否合适，看纵向y坐标定，x循环
	// for(int i=0;i<8;i++){
	// if(x-i >= 0 && y-i >= 0){
	// if('1' == arr[x-i][y-i])
	// return 0;
	// }
	// if(x+i <= 7 && y+i <= 7){
	// if('1' == arr[x+i][y+i])
	// return 0;
	// }
	// }
	// return 1;
	// }
	// public static void show(char[][] x){
	// for(int i=0;i<8;i++){
	// for(int j=0;j<8;j++)
	// System.out.print(x[i][j]);
	// System.out.println();
	// }
	// System.out.println("======================\n");
	// }

	static int b[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
	static int sum = 0;
	static int times = 1;

	public static void main(String[] args) {
		search(0);
		System.out.println("一共有" + sum + "个结果");
	}

	/**
	 * 搜索指定行
	 * 
	 * @param row
	 */
	private static void search(int row) {
		if (row == 8) {
			sum++;
			printResult();
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (check(row, i)) {
				search(row + 1);
			}
		}
	}

	/**
	 * 检查m,n 这个位置是否冲突
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (b[i] == col) {
				return false;
			}
			if ((b[i] + i) == (row + col)) {
				return false;
			}
			if ((b[i] - i) == (col - row)) {
				return false;
			}
		}

		b[row] = col;
		return true;
	}

	/**
	 * 打印结果
	 */
	private static void printResult() {
		System.out.print(times++ + "： ");
		for (int i = 0; i < 8; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println(" ");
	}
}
