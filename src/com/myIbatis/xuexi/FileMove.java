package com.myIbatis.xuexi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import de.schlichtherle.io.FileInputStream;

public class FileMove {

	public static void main(String[] args) {

		String file = "D:/11";
		File in = new File(file);
		for (int i = 0; i < in.listFiles().length; i++) {
			System.out.println(in.listFiles()[i].getName());
			String name = in.listFiles()[i].getName();// 获取文件名
			String path = in.listFiles()[i].getPath();// 获取文件路径
			String lx = name.substring(name.indexOf("."));
			if (lx.equals(".txt")) {
				copy(new File(name));
			}
		}
	}

	public static void copy(File file) {
		try {
			System.out.println(file.getName());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream("D://11//" + file)));
			PrintWriter out = new PrintWriter("D://222//"
					+ file.toString()
							.substring(0, file.toString().indexOf("."))
					+ ".jad");
			System.out.println("D://222//"
					+ file.toString()
							.substring(0, file.toString().indexOf("."))
					+ ".jad");
			String line = null;
			if ((line = in.readLine()) != null) {
				out.write(line);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
