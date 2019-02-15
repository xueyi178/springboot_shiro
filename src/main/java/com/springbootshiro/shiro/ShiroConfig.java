package com.springbootshiro.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * 1、shiro的配置类
 * 项目名称：springboot_shiro 
 * 类名称：ShiroConfig
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午8:01:32
 */
@Configuration
public class ShiroConfig {

	/**
	 * 1、创建一个ShiroFilterFactoryBean
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean getshiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		filterFactoryBean.setSecurityManager(securityManager);
		//添加shiro的内置过滤器
		/**
		 * Shiro内置过滤器:可以实现权限相关的拦截器
		 * 		常见的过滤器：
		 * 			anon：无需认证(登录)就可以访问
		 * 			authc：必须认证了才能访问
		 *			user：如果使用rememberMe的功能可以直接访问
		 * 			persm：该资源必须得到资源权限才可以访问
		 * 			role：该资源必须得到角色权限才可以访问
		 */
		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.clear();
		//可以一个一个的配置
		/*filterMap.put("/user/add", "authc");
		filterMap.put("/user/update", "authc");*/

		//放行login的请求
		filterMap.put("/user/login", "anon");
		filterMap.put("/user/testThymelaf", "anon");

		//修改登录的页面
		filterFactoryBean.setLoginUrl("/user/toLogin");

		//授权过滤器,当授权拦截后shiro会自动跳转到未授权的页面
		filterMap.put("/user/add", "perms[user:add]");
		filterMap.put("/user/update", "perms[user:update]");
		
		

		//也可以采用通配符的方式
		filterMap.put("/user/*", "authc");

		//设置一个未授权的提示页面
		filterFactoryBean.setUnauthorizedUrl("/user/unAuth");
		
		//把map设置到拦截器中
		filterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return filterFactoryBean;
	}

	/**
	 * 2、创建一个DefaultWebSecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		//关联realm
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}

	/**
	 * 3、创建了一个Realm类
	 * @return
	 * @Bean：表示把对象放到spring环境中
	 */
	@Bean(name="userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
		
	/**
	 * 4、配置ShiroDialect,用于thymeleaf和shiro标签的配合使用
	 */
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
}
