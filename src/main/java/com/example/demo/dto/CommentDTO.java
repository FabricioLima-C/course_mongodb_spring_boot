package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String comment;
	private Date date;
	
	private AuthorDTO author;

	public CommentDTO() {
		
	}

	public CommentDTO(String comment, Date date, AuthorDTO author) {
		this.comment = comment;
		this.date = date;
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
