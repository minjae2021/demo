package com.example.demo.controller;

import java.sql.Blob;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostForm {
	
	public Long postId;
	
	@NotEmpty(message="제목은 필수입니다.")
	public String title;
	@NotEmpty(message="내용은 필수입니다.")
	public String content;
	@NotEmpty(message="작성자는 필수입니다.")
	public String writer;
	
/*	public Blob file;*/
}
