package com.jiyiren.mvnspdemo.bean.domodel;

import java.util.Date;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年4月23日 上午10:30:38
 * @Description 用户表DO
 */
public class UserDO {

	private Long id;
	private String userName;
	private String passWord;
	private Integer age;
	private Date createTime;
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "UserDO [id=" + id  + ", userName=" + userName + ", passWord=" + passWord
				+ ", age=" + age + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
