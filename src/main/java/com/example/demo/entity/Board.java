package com.example.demo.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BOARD")
@NoArgsConstructor
@Getter @Setter
public class Board {
	
	@Id @GeneratedValue
	@Column(name="BOARD_ID")
	public Long boardId;
	
	@Column(name="NAME")
	public String name;
	
	public Board(String name) {
		this.name = name;
	}
}
