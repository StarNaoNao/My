package com.myIbatis.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FTPTest {
	public static void main(String[] args) {
		// 设置ftp
		KmConfig km = new KmConfig();
		km.setFtpHost("192.168.0.174");
		km.setFtpPort(2121);
		km.setFtpUser("FtpTest");
		km.setFtpPassword("casic");
		km.setFtpPath("KM");
		// 上传到ftp
		FtpUtil util = new FtpUtil();
		File file = new File("F:/旅馆测试情况登记表.docx");
		InputStream in;
		try {
			in = new FileInputStream(file);
			FtpUtil.upLoadFileFtp(km, in, "更改后的名字.docx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
