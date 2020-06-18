package com.learn.jpa.Repository;

import com.learn.jpa.entity.QueryTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends CrudRepository<QueryTest, Long> {

	@Override
	<S extends QueryTest> S save(S entity);

}
