package com.springbootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、springboot默认的启动类
 * 项目名称：springboot_shiro 
 * 类名称：Application
 * 开发者：Lenovo
 * 开发时间：2019年2月15日下午7:35:10
 */
@SpringBootApplication
@MapperScan("com.springbootshiro.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
