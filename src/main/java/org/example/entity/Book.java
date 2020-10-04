package org.example.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "bookid", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "authorid", nullable = false)
	private Author authorId;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	private String bookname;

	private Double bookprice;

	private Date createdate;

	private Date publishdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Author getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}

	public Double getBookprice() {
		return bookprice;
	}

	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
}