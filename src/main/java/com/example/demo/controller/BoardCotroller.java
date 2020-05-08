package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardCotroller {
	
	@Autowired BoardService boardService; 
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/board")
	public String board(Model model) {
		List<Board> boards = boardService.findAll();
		model.addAttribute("boards",boards);
		return "board";
	}
}
