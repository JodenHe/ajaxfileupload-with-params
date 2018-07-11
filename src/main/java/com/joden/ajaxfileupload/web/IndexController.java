package com.joden.ajaxfileupload.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * controller
 * 
 * @author Jodenhe create on 2018年7月11日 上午11:01:21
 */
@Controller
public class IndexController {

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping({ "", "/", "/index", "index.html" })
	public String index() {
		return "index";
	}

	/**
	 * 文件上传以及参数获取
	 * 
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(Student student, @RequestParam("file") MultipartFile file) {
		System.out.println(student);
		System.out.println(file.getOriginalFilename());
		return "success";
	}

	// 内部 dto
	// 学生
	@Data
	public static class Student {
		private Long id;
		private String name;
		private List<Subject> subjectList;
	}

	// 科目
	@Data
	public static class Subject {
		private Long id;
		private Integer score;
		private String name;
		private Teacher teacher;
	}

	// 老师
	@Data
	public static class Teacher {
		private Long id;
		private String name;
	}

}
