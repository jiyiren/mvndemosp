package com.jiyiren.mvnspdemo.dao;

import org.apache.ibatis.annotations.Param;

import com.jiyiren.mvnspdemo.bean.domodel.UserDO;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月23日 上午11:07:52
 * @Description 用户账号相关数据接口
 * 用户名不允许相同
 */
public interface UserDao {
	
	/**
	 * 根据用户名判断是否已经存在相同的用户名
	 * @param userName 用户名
	 * @return         用户的Id: >=1L时存在该用户名,null时无此用户名
	 * 若没有匹配值时，此查询结果在mybatis中是null，因此不能用原生类型long
	 */
	Long getUserIdByUserName(@Param("userName") String userName);
	
	/**
	 * 保存用户信息
	 * @param userName 用户名称
	 * @param passWord 用户密码
	 * @return         返回受影响的行数:1为成功,0为失败
	 */
	int saveUser(@Param("userName") String userName,@Param("passWord") String passWord);
	
	/**
	 * 查询用户信息
	 * @param userName 用户名称
	 * @param passWord 用户密码
	 * @return         返回用户信息: null无此用户或密码不正确,非空则为登录成功
	 */
	UserDO getUser(@Param("userName") String userName,@Param("passWord") String passWord);
	
	/**
	 * 根据用户Id查询用户信息
	 * @param userId   用户的Id
	 * @return         返回用户信息: null无此用户或密码不正确,非空则为获取成功
	 */
	UserDO getUserById(@Param("userId") Long userId);
	
}
