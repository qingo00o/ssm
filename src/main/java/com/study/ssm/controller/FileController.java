package com.study.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/rest/file")
public class FileController {
	
	@RequestMapping("/index")
	public String fileIndex() {
		return "loadFile";
	}

	/**
	 * 文件上传功能
	 * @Title upload
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws IOException String
	 * @author Dujian
	 * @Date 2018年10月12日
	 */
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(MultipartFile file,HttpServletRequest request) throws Exception, IOException {
		String path=request.getSession().getServletContext().getRealPath("upload");
		String fileName=file.getOriginalFilename();
		File dir=new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		file.transferTo(dir);
		return "ok";
	}
	/**
	 * 文件下载
	 * @Title down
	 * @param request
	 * @param response
	 * @throws IOException void
	 * @author Dujian
	 * @Date 2018年10月12日
	 */
	@RequestMapping("/down")
	public void down(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//模拟文件，myfile.txt为需要下载的文件
		String fileName=request.getSession().getServletContext().getRealPath("upload")+"/myfile.txt";
		
		//获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
		//假如以中文名下载的话
		String filename = "下载文件.txt";
		//转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename,"UTF-8");
		
		//设置文件下载头
		 response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		 
		//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		 response.setContentType("multipart/form-data"); 
	     BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
	     int len = 0;
	        while((len = bis.read()) != -1){
	            out.write(len);
	            out.flush();
	        }
	        out.close();
	        bis.close();
	}
	
}
