package com.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 1、用户的controller
 * 项目名称：springboot_shiro 
 * 类名称：UserController
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午7:35:38
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	/**
	 * 1、测试程序是否能通
	 * @return
	 */
	@GetMapping(value="hello")
	@ResponseBody
	public String hello() {
		System.out.println("你好吗就是可敬的");
		return "ok";
	}
	
	/**
	 * 2、跳转到添加的页面
	 * @return
	 */
	@GetMapping(value="/add")
	public String add() {
		System.out.println("你好吗就是可敬的");
		return "user/add";
	}
	
	/**
	 * 3、跳转到更新的页面
	 * @return
	 */
	@GetMapping(value="/update")
	public String update() {
		System.out.println("你好吗就是可敬的");
		return "user/update";
	}
	
	/**
	 * 4、测试Thymelaf
	 * @param model
	 * @return
	 */
	@GetMapping(value="/testThymelaf")
	public String testThymelaf(Model model) {
		model.addAttribute("name", "黑马程序员");
		return "test";
	}
	
	/**
	 * 5、跳转到登录的页面
	 * @param model
	 * @return
	 */
	@GetMapping(value="/toLogin")
	public String toLogin(Model model) {
		return "login";
	}
	
	@GetMapping(value = "/unAuth")
	public String unAuth() {
		return "uoAuth";
	}
	
	/**
	 * 6、登录的页面
	 * @param name
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping(value="/login")
	public String login(String name, String password, Model model) {
		System.out.println("进来了登录的页面");
		/**
		 * 1、使用shiro来进行编写认证
		 */
		//1、获取subject主体
		Subject subject = SecurityUtils.getSubject();
		
		//2、封装用户的数据
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
	
		//3、执行登录操作
		try {
			//没有异常登录成功
			subject.login(token);
			return "redirect:/user/testThymelaf";
		} catch (UnknownAccountException e) {
			//e.printStackTrace();
			//登录失败：用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
}
