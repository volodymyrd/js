package com.gmail.volodymyrdotsenko.routing.frontend.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingPageController {

	@RequestMapping("/")
	public String index(HttpServletRequest httpServletRequest) {
		System.out.println("Landing page...");
		return "index";
	}
}
