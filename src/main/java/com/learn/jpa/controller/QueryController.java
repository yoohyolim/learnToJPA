package com.learn.jpa.controller;

import com.learn.jpa.entity.QueryTest;
import com.learn.jpa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jpa/test")
public class QueryController {

	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {
		this.queryService = queryService;
	}


	@RequestMapping("/insert")
	public ModelAndView main(){

		return new ModelAndView("/query/insert");
	}

	@RequestMapping("/save")
	public ModelAndView save(QueryTest queryTest){
		ModelAndView mv = new ModelAndView("/query/result");
		QueryTest result = queryService.save(queryTest);
		boolean resultBoolean = false;
		if(result != null){
			resultBoolean = true;
		}
		mv.addObject("booleanResult", resultBoolean);
		mv.addObject("result", result);
		return mv;
	}

}
