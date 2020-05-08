package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.org.apache.bcel.internal.generic.NEW;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="POST")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class Post extends BaseTimeEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="POST_ID")
	public Long postId;
	
	@Column(name="TITLE")
	public String title;
	
	@Column(name="CONTENT")
	public String content;
	
	@Column(name="WRITER")
	public String writer;
	
	@OneToMany(mappedBy="post")
	@Column(name = "FILE_ID")
	public List<File> files = new ArrayList<>();
}
