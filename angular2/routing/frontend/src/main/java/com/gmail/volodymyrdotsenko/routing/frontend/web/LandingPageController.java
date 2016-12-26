package com.gmail.volodymyrdotsenko.routing.frontend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LandingPageController {

	@RequestMapping("/")
	public String index(HttpServletRequest httpServletRequest) {
		System.out.println("Landing page...");
		return "redirect:/index.html";
	}
}
