package com.springbootshiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootshiro.domain.User;
import com.springbootshiro.service.UserService;
/**
 * 1、自定义realm类
 * 项目名称：springboot_shiro 
 * 类名称：UserRealm
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午8:03:46
 */
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 1、认证的逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行了认证的逻辑");
		
		//1、编写shiro的判断逻辑,判断用户名和密码
		//判断用户名
		UsernamePasswordToken token2 = (UsernamePasswordToken)token;
		
		User user = userService.findByName(token2.getUsername());
		if(null == user) {
			//用户名不存在,shiro底层自动会抛出UnknownAccountException异常
			return null;
		}
		
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

	/**
	 * 2、授权的逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行了授权的逻辑");
		//1、给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//2、添加资源的授权字符串
		//info.addStringPermission("user:add");
		//从数据库里面进行查询权限标识符
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		User findById = userService.findById(user.getId());
		info.addStringPermission(findById.getPerms());
		return info;
	}
}
