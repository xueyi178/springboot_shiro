package com.springbootshiro.domain;

import java.io.Serializable;
/**
 * 1、user的实体类
 * 项目名称：springboot_shiro 
 * 类名称：User
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午9:25:00
 */
public class User implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2165353153132213947L;

	private Integer id;
	
	private String name;
	
	private String password;
	
	private String perms;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}
}
