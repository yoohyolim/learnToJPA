package com.learn.jpa.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name="table_for_jpa")
public class QueryTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	@Column(name = "title", length = 50)
	private String title;
	@Column(name = "contents", length = 255)
	private String contents;
	@Column(name = "writer", length = 50)
	private String writer;
	/**
	 * -부장님께 여쭤보기 전-
	 * 테이블 생성 시 컬럼에 디폴트로 CURRENT_TIMESTAMP 지정해놔도 아무런 설정해주지 않으면 컬럼에 현재 시간이 저장되지 않는다.
	 * 그래서 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"를 추가해줬고,
	 * insertable에 false를 설정해주면 데이터베이스에 저장하지 않지만 "삽입"일 때만 적용된다. (즉, false를 주게 되면 읽기 전용이다.)
	 * updateable에 false를 설정해주면 데이터베이스에 저장하지 않지만 "수정"일 때만 적용된다. (즉, false를 주게 되면 읽기 전용이다.)
	 * Generated(GenerationTime.INSERT) : insert할 때만 / @Generated(GenerationTime.ALWAYS) : 항상
	 */
	/**
	 * -부장님께 여쭤본 후-
	 * 위와 같은 방식은 거의 사용하지 않고 (안되는 것은 아님) @PrePersist와 같은 어노테이션을 이용해 insert하기 전에 값을 set해줌.
	 * 아래에 구현하겠음
	 */
	@Column(name = "created")
	private String created;

	@Column(name = "updated")
	private String updated;

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	//처음으로 생성될 때 : created, updated 모두
	@PrePersist
	protected void onCreate(){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		created = simple.format(new Date());
		updated = simple.format(new Date());
	}

	//업데이트될 때 : updated만
	@PreUpdate
	protected void onUpdate(){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		updated = simple.format(new Date());
	}
}
