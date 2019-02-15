package com.springbootshiro.mapper;

import com.springbootshiro.domain.User;

/**
 * 1、用户的数据访问层接口
 * 项目名称：springboot_shiro 
 * 类名称：UserMapper
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午9:26:26
 */
public interface UserMapper {

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
