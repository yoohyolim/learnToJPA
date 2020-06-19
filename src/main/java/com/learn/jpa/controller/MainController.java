package com.learn.jpa.controller;

import com.learn.jpa.entity.QueryTest;
import com.learn.jpa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private final QueryService queryService;

	@Autowired
	public MainController(QueryService queryService) {
		this.queryService = queryService;
	}

	@RequestMapping("/")
	public ModelAndView main(@ModelAttribute("queryTest") QueryTest queryTest){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("datalist", queryService.read());
		return mv;
	}
}
