package com.springbootshiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootshiro.domain.User;
import com.springbootshiro.mapper.UserMapper;
import com.springbootshiro.service.UserService;
/**
 * 1、用户操作的业务逻辑层实现类
 * 项目名称：springboot_shiro 
 * 类名称：UserServiceImpl
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午9:33:17
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 1、根据账号查询用户信息
	 * @param name
	 * @return
	 */
	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	/**
	 * 2、根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	@Override
	public User findById(Integer id) {
		return userMapper.findById(id);
	}

}
