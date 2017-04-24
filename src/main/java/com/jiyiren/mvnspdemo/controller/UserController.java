package com.jiyiren.mvnspdemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jiyiren.mvnspdemo.bean.domodel.UserDO;
import com.jiyiren.mvnspdemo.service.UserService;
import com.jiyiren.mvnspdemo.utils.StringHelper;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月23日 上午10:34:34
 * @Description 用户功能
 */
@Controller
@SessionAttributes({"user"})//设置session
public class UserController {
	
	private static final String LOGIN_PAGE="user/login";
	private static final String REGISTER_PAGE="user/register";
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLogin(){
		return LOGIN_PAGE;
	}
	
	@GetMapping("/register")
	public String getRegister(){
		return REGISTER_PAGE;
	}
	
	@PostMapping("/login")
	public String postLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,Map<String,Object> map){
		if(StringHelper.isEmpty(username)||StringHelper.isEmpty(password)){
			return "login";
		}
		
		UserDO result=userService.login(username, password);
		if(result==null){
			map.put("loginResult", "用户名或密码错误!");//错误提示
			return LOGIN_PAGE;
		}
		map.put("user", result);
		return "redirect:index";
	}
	
	@PostMapping("/register")
	public String postRegister(@RequestParam("username") String userName,
			@RequestParam("password") String passWord,Map<String,Object> map){
		if(StringHelper.isEmpty(userName)||StringHelper.isEmpty(passWord)){
			return "redirect:register";
		}
		Integer result=userService.register(userName, passWord);
		if(result == null){
			map.put("registerResult", " 注册失败!");//错误提示
			return REGISTER_PAGE;
		}
		if(result.equals(1)){
			return "redirect:login";
		}
		if(result.equals(-1)){
			map.put("registerResult", "用户名已经存在!");//错误提示
		}
		return REGISTER_PAGE;
	}

	/**
	 * 用户登录成功后的初始化事件
	 */
	private void initEvent(){
		
	}
}
