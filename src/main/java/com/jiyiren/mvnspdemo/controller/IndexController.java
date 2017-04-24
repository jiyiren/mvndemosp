package com.jiyiren.mvnspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月24日 上午9:48:36
 * @Description 
 */
@Controller
public class IndexController {
	
	@GetMapping("/")
	public String getRoot(){
		return "redirect:index";
	}
	
	@GetMapping("/index")
	public String getIndex(){
		return "index";
	}
}
