package com.example.reactProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.minidev.json.JSONObject;

@RestController			// rendering 하지 않고, 데이터를 보내는 컨트롤러 (ResponseBody 느낌)
@RequestMapping("/react")
public class ReactController {
	
	@GetMapping("/data")
	public String data() {
		return "스프링부트에서 보낸 데어터";
	}
	
	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제임스");
		return jObj.toString();
	}
	
	@PostMapping("/from")
	public String form(String uid, String uname) {
		System.out.println("uid" + uid + ", uname=" + uname);
		return "uid=" + uid + ", uname=" + uname;
	}
	
	@PostMapping("/multi")
	public String form(String uid, String uname, MultipartFile file) {
		String msg = "uid=" + uid + ", unmae" + uname + ", fname=" + file.getOriginalFilename();
		return msg;
	}
	
}

