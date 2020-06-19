package com.learn.jpa.serviceImpl;

import com.learn.jpa.entity.QueryTest;
import com.learn.jpa.Repository.QueryRepository;
import com.learn.jpa.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * RequiredArgsConstructor : 롬복쓸때만 의존성주입할 때 사용 ( @Autowired 대신 )
 */
@RequiredArgsConstructor
@Transactional
@Service("QueryService")
public class QueryServiceImpl implements QueryService {

	private final QueryRepository queryRepository;

	/**
	 * 단일 데이터 insert
	 * @param queryTest
	 * @return
	 */
	@Override
	public QueryTest save(QueryTest queryTest){ return queryRepository.save(queryTest); }

	/**
	 * 모든 데이터 불러오기
	 * @return
	 */
	@Override
	public List<QueryTest> read(){ return (List<QueryTest>) queryRepository.findAll(); }

	/**
	 * 단일 데이터 삭제
	 * @param seq
	 */
	@Override
	public void delete(long seq){ queryRepository.deleteBySeq(seq); }

	/**
	 * 단일 데이터 불러오기
	 * @param seq
	 * @return
	 */
	@Override
	public QueryTest findBySeq(long seq){ return queryRepository.findBySeq(seq); }

}
