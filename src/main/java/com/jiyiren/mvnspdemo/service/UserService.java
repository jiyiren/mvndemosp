package com.jiyiren.mvnspdemo.service;

import com.jiyiren.mvnspdemo.bean.domodel.UserDO;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月24日 上午10:34:26
 * @Description 
 * 接口里不要加限定词
 */
public interface UserService {
	
	/**
	 * 用户注册
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return         返回是否注册成功: >=1成功,null或0失败,-1用户名已经存在
	 * (这里返回值用Integer而不是Boolean是为了更好地扩展，
	 * 比如1为注册成功,-1为用户名已经存在等更精确的判断)
	 */
	Integer register(String userName,String passWord);
	
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return         返回是否登录成功:null失败,否则成功，并携带用户信息
	 */
	UserDO login(String userName,String passWord);
}
