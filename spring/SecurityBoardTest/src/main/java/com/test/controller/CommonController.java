<<<<<<< HEAD
package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/template.do")
	public String template() {
		
		return "template";
	}
	
	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
}
=======
package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/template.do")
	public String template() {
		
		return "template";
	}
	
	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
}
>>>>>>> branch 'main' of https://github.com/sorrel012/code
