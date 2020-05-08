package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="FILE")
@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class File {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	public Long fileId;
	
	@Column(name = "FILE_NAME")
	public String fileName;
	
	@Column(name = "FILE_TYPE")
	public String fileType;
	
	@Lob
	@Column(name = "DATA")
	public byte[] data;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "POST_ID", foreignKey = @ForeignKey(name="FILE_ibfk_1"))
	public Post post;
}
