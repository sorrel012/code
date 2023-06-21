<<<<<<< HEAD
package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/member/login.do")
	public String login() {
		
		return "member/login";
	}
	
	@GetMapping("/member/logout.do")
	public String logout() {
		
		return "member/login";
	}
	
}
=======
package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/member/login.do")
	public String login() {
		
		return "member/login";
	}
	
	@GetMapping("/member/logout.do")
	public String logout() {
		
		return "member/login";
	}
	
}
>>>>>>> branch 'main' of https://github.com/sorrel012/code
