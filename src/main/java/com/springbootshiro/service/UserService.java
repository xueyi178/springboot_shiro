package com.springbootshiro.service;
/**
 * 1、用户的业务逻辑层接口
 * 项目名称：springboot_shiro 
 * 类名称：UserService
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午9:32:30
 */

import com.springbootshiro.domain.User;

public interface UserService {

	/**
	 * 1、根据账号查询用户信息
	 * @param name
	 * @return
	 */
	public User findByName(String name);

	/**
	 * 2、根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
}
