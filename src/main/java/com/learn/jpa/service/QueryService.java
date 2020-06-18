package com.learn.jpa.service;

import com.learn.jpa.entity.QueryTest;
import org.springframework.stereotype.Service;

@Service
public interface QueryService {

	QueryTest save(QueryTest queryTest);

}
