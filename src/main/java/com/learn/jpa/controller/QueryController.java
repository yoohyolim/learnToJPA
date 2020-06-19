package com.learn.jpa.controller;

import com.learn.jpa.entity.QueryTest;
import com.learn.jpa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class QueryController {

	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {
		this.queryService = queryService;
	}

	/**
	 * 데이터 저장 Ajax
	 * @param queryTest
	 * @return
	 */
	@RequestMapping("/saveAjax")
	public boolean save(QueryTest queryTest){
		QueryTest result = queryService.save(queryTest);
		boolean resultBoolean = false;
		if(result != null){
			resultBoolean = true;
		}
		return resultBoolean;
	}

	/**
	 * 단일 데이터 불러오기 Ajax
	 * @param seq
	 * @return
	 */
	@RequestMapping("/findBySeq")
	@ResponseBody
	public QueryTest findBySeq(long seq){
		return queryService.findBySeq(seq);
	}

}
