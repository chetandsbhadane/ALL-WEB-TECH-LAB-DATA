package com.blogs.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test") // optional BUT reco for separation
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}

	// URL - http://host:port/ctx_path/test/test1
	// add a method to test MnV
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test m n v");
		// o.s.w.s.ModelAndView(String LVN,String attrName,Object attaval)
		return new ModelAndView("/test/display", "server_ts", LocalDateTime.now());
		/*
		 * Handler rets MnV --> D.S D.S -> LVN -> V.R -> AVN -> D.S D.S adds model attr
		 * under req scope --> forward the clnt AVN - /WEB-INF/views/test/display.jsp
		 */

	}

	// URL - http://host:port/ctx_path/test/test2
	// add a method to test model map
	@GetMapping("/test2")
	public String testModelMap(Model modelMap) {
		System.out.println("in test model map "+modelMap);//{}
		//add 2 model attrs  - server ts , list of nos - 10,20,30,40
		modelMap.addAttribute("ts", LocalDateTime.now())
		.addAttribute("num_list", List.of(10, 20, 30, 40));
		System.out.println("map again "+modelMap);
		return "/test/display2";
		/*
		 * Handler rets -- explicitly LVN (impl Model map) --D.S
		 * D.S --> LVN --> V.R -> AVN -> D.S
		 * chks for results(Model map) --> adds it under req scope
		 * forwards -> view 
		 * AVN - /WEB-INF/views/test/display2.jsp
		 */
	}
}
