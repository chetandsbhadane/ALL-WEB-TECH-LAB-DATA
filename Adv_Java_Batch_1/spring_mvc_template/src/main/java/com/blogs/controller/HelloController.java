package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // To tell SC , following is a spring bean
//containing req handling logic - mandatory
//singleton n eager 
public class HelloController {
	public HelloController() {
		System.out.println("in ctor " + getClass());
	}
	//add request handling method , to test MVC flow
	/*
	 * SC adds the entry in the HandlerMapping bean
	 * key - /hello
	 * value -F.Q controller cls name+ method name
	 * (com.blogs.controller.HelloController.sayHello)
	 */
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";
		/*
		 * Handler(=Req handling controller) method rets LVN
		 * logical view name(=forward view name) --> D.S
		 * --> V.R (view reslover) -> AVN (prefix+LVN+suffix)
		 * AVN - /WEB-INF/views/welcome.jsp
		 */
	}
}
