package com.jiyiren.mvnspdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiyiren.mvnspdemo.bean.domodel.UserDO;
import com.jiyiren.mvnspdemo.dao.UserDao;
import com.jiyiren.mvnspdemo.utils.StringHelper;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月24日 下午2:53:40
 * @Description  用户账号业务
 */
@Repository("userService")
public class UserServiceImp implements UserService {

	//日志只在Business层统一打印，不要在Controller层，以及DAO层打印日志
	private static final Logger log=LoggerFactory.getLogger(UserServiceImp.class);
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Integer register(String userName, String passWord) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(userName)||StringHelper.isEmpty(passWord)){
			return 0;
		}
		
		Long userId=userDao.getUserIdByUserName(userName);
		if(userId!=null&&userId>=1){
			return -1;
		}
		
		int success=userDao.saveUser(userName, passWord);//这里有可能会有mybatis的异常
		if(log.isDebugEnabled()){
			log.debug("user register result:{}", success);
		}
		if(success>=1){
			return 1;
		}
		return null;
	}

	@Override
	public UserDO login(String userName, String passWord) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(userName)||StringHelper.isEmpty(passWord)){
			return null;
		}
		
		UserDO userDO=userDao.getUser(userName, passWord);
		if(log.isDebugEnabled()){
			log.debug("user login result:{}", userDO==null?"":userDO.toString());
		}
		return userDO;
	}

	

}
