package com.learn.jpa.service;

import com.learn.jpa.entity.QueryTest;

import java.util.List;

public interface QueryService {

	QueryTest save(QueryTest queryTest);

	List<QueryTest> read();

	void delete(long seq);

	QueryTest findBySeq(long seq);

}
