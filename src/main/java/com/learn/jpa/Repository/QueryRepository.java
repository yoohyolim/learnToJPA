package com.learn.jpa.Repository;

import com.learn.jpa.entity.QueryTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("QueryRepository")
public interface QueryRepository extends CrudRepository<QueryTest, Long> {

	void deleteBySeq(long seq);
}
