package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "DBtest (1)";
	}
	
	@RequestMapping("/dbtest")
	public String welcom1() {		
		return "dbtest";
	}
	
	// 블루마켓 유저 목록
	@RequestMapping("/bluemarket")
	public String welcom2() {		
		return "bluemarket";
	}
	
	@RequestMapping("/uploadForm")
	public String uploadForm() {
	return "FileUpload/fileForm";
	}

	// 테스트중
//	@RequestMapping("/uploadOk")
//	public @ResponseBody String uploadOk(HttpServletRequest request) 
//	{
//		int size = 1024 * 1024 * 10; //10M
//		String file = "";
//		String oriFile = "";
//
//		JSONObject obj = new JSONObject();
//		try 
//		{
//			String path = ResourceUtils
//			.getFile("classpath:static/upload/").toPath().toString();
//		
//			MultipartRequest multi = new MultipartRequest(request, path ,size,
//			"UTF-8", new DefaultFileRenamePolicy());
//			System.out.println(path);
//			Enumeration files = multi.getFileNames();
//			String str = (String)files.nextElement();
//		
//			file = multi.getFilesystemName(str);
//			oriFile = multi.getOriginalFileName(str);
//		
//			obj.put("success", new Integer(1));
//			obj.put("desc", "업로드 성공");
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			obj.put("success", new Integer(0));
//			obj.put("desc", "업로드 실패");
//		}
//	
//		return  obj.toJSONString();
//		
//	}

}