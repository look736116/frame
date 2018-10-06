package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/common")
public class CommonController {

	@RequestMapping(value = "/main")
	public String toMainPage(final HttpServletRequest request, HttpServletResponse response) {

		return "common/main";
	}
	
	@RequestMapping(value = "/header")
	public String toHeaderPage(final HttpServletRequest request, HttpServletResponse response) {

		return "common/header";
	}
	
	@RequestMapping(value = "/footer")
	public String toFooterPage(final HttpServletRequest request, HttpServletResponse response) {

		return "common/footer";
	}
}
