package com.learn.jpa.serviceImpl;

import com.learn.jpa.entity.QueryTest;
import com.learn.jpa.Repository.QueryRepository;
import com.learn.jpa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QueryServiceImpl")
public class QueryServiceImpl implements QueryService {

	private final QueryRepository queryRepository;

	@Autowired
	public QueryServiceImpl(QueryRepository queryRepository) {
		this.queryRepository = queryRepository;
	}

	public QueryTest save(QueryTest queryTest){ return queryRepository.save(queryTest); }

}
