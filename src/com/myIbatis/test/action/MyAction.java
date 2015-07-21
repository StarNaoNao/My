package com.myIbatis.test.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myIbatis.test.entity.User;
import com.myIbatis.test.service.MyService;
import com.myIbatis.test.util.PropertyConfigurer;

@Controller
@RequestMapping("myibatis")
public class MyAction {

	@Autowired
	public MyService myservice;

	@RequestMapping("toMain")
	public String toMain() {
		String s = PropertyConfigurer.getValue("jdbc.driver");
		System.out.println("jdbc.driver="+ s + "~~~~~~~~");
		return "index";
	}

	@RequestMapping("toUpload")
	public String toUpload() {
		System.out.println("========toUpload========");
		return "upload";
	}

	@RequestMapping("totestIframe")
	public String totestIframe() {
		return "totestIframe";
	}

	@RequestMapping("showData")
	// public String showData(Model model){
	public ModelAndView showData(HttpServletRequest request) {
		String name = request.getParameter("text");
		System.out.println("name = " + name);
		List<User> users = myservice.getUsers();
		User user = myservice.getUserByName(name);
		System.out.println(user.getId() + "  " + user.getName());
		// model.addAttribute("users",users);
		// System.out.println(users);
		// return "showUser";
		return new ModelAndView("showUser").addObject("users", users)
				.addObject("user", user);
		// new ModelAndView(new
		// RedirectView("toPtMiddle.html"));//controller的RequestMapping之间的跳转
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("upload")
	public ModelAndView upload(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf8");// 支持中文文件名
			List<FileItem> items = upload.parseRequest(request);
			// 项目路径获取办法，可以得到：D:\apache-tomcat-6.0.41\webapps\my\
			String realPath = request.getSession().getServletContext()
					.getRealPath("/");
			System.out.println(realPath);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					System.out.println("查找到一个普通文本数据");
					System.out.println("该文本数据的name为：" + item.getFieldName());
					System.out.println("该文本数据的value为：" + item.getString());
					System.out.println();
				} else {
					System.out.println("查找到一个二进制数据");
					System.out.println("该文件表单name为：" + item.getFieldName());
					// 这里是带有路径的文件名，可以通过获取子串的方式得到不带路径的文件名
					// 用于在下面保存文件时，动态指定保存位置
					System.out.println("该文件文件名为：" + item.getName());
					// 删除前台带上传的文件的路径，只留下文件名，得到如：/小明.doc
					System.out.println("删除路径后名称："
							+ item.getName().substring(
									item.getName().lastIndexOf("\\")));
					System.out.println("该文件文件类型为：" + item.getContentType());
					System.out.println("该文件文件大小为：" + item.getSize());
					System.out.println();
					// 保存文件
					File uploadedFile = new File(
							"C:\\Users\\Stu\\Desktop\\aaa.docx");
					item.write(uploadedFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("success");
	}

	@RequestMapping("download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		response.reset();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		try {
			// 获取源文件大小
			long fileLength = new File("C:\\Users\\Stu\\Desktop\\aaa.docx")
					.length();
			response.setContentType("application/x-msdownload;");
			String fileName1 = new String(request.getParameter("fileName")
					.getBytes("ISO-8859-1"), "UTF-8");
			response.reset();
			// 指定响应方式，以及确定下载提示框中文件名称(在"attachment;filename="后面)
			response.setHeader("content-disposition", "attachment;filename="
					+ new String(fileName1.getBytes(), "utf-8") + ".docx");
			response.setHeader("Content-Length", String.valueOf(fileLength));
			// 指定源文件输入流
			bis = new BufferedInputStream(new FileInputStream(new File(
					"C:\\Users\\Stu\\Desktop\\aaa.docx")));
			bos = new BufferedOutputStream(response.getOutputStream());
			int bytesRead;
			byte[] buff = new byte[2048];
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bis.close();
			bos.close();
		}
		return null;
	}

	@RequestMapping("AndroidTest")
	public String AndroidTest(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("POST");
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		response.setCharacterEncoding("UTF-8");

		String sessionId = request.getSession().getId();

		// 注意，可以将登陆信息放入session中，用于登陆保持
		request.getSession().setAttribute("username", username);

		JSONArray json = new JSONArray();
		List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("type", "success");
		map1.put("sessionId", sessionId);
		retList.add(map1);

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("type", "fail");
		map2.put("sessionId", sessionId);
		retList.add(map2);

		json = JSONArray.fromObject(retList);
		System.out.println(json);

		OutputStream out = response.getOutputStream();
		out.write(json.toString().getBytes("UTF-8"));
		out.close();
		return null;
	}

	/**
	 * 警情会商列表
	 */
	@RequestMapping("jqhsList")
	public String jqhsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Map<String, Object>> retList = myservice.getAllJqhs();
		// 判断会商是否已开始，是则显示会商状态为正在进行
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < retList.size(); i++) {
			String kssj = (String) retList.get(i).get("KSSJSTR");
			String systime = (String) retList.get(i).get("SYSTIME");
			String hsbt = (String) retList.get(i).get("HSBT");
			try {
				Date dt1 = format.parse(kssj);
				Date dt2 = format.parse(systime);
				if (dt1.getTime() <= dt2.getTime()) {
					if (retList.get(i).get("HSZTXX").equals("1")) {
						// 系统时间不小于会商开始时间，可发言
						retList.get(i).put("HSZTXX", "3");
					}
				}
				retList.get(i).put("HSBT", URLEncoder.encode(hsbt, "UTF-8"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		JSONArray json = new JSONArray();
		json = JSONArray.fromObject(retList);
		System.out.println(json);
		OutputStream out = response.getOutputStream();
		out.write(json.toString().getBytes("UTF-8"));
		out.close();
		return null;
	}
}
