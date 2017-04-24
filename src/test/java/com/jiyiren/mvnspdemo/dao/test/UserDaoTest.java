package com.jiyiren.mvnspdemo.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiyiren.mvnspdemo.bean.domodel.UserDO;
import com.jiyiren.mvnspdemo.dao.UserDao;


/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月24日 下午12:45:41
 * @Description 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void getUserIdByUserNameTest(){
		Long userId=userDao.getUserIdByUserName("jiyiren");
		System.out.println("userId:"+userId);
	}
	
	@Test
	public void saveUserTest(){
		int userId=userDao.saveUser("jiyiren4", "123456");
		System.out.println("isOk:"+userId);
	}
	
	@Test
	public void getUserTest(){
		UserDO userDo=userDao.getUser("jiyiren","123456");
		if(userDo==null){
			System.out.println("null");
		}else{
			System.out.println(userDo.toString());
		}
	}
	
	@Test
	public void getUserByIdTest(){
		Long userId=2L;
		UserDO userDO=userDao.getUserById(userId);
		System.out.println(userDO.toString());
	}
	
}
