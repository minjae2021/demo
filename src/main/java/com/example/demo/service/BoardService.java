package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	public void saveBoard(Board board) {
		boardRepository.save(board);
	}
	
	public Board findOne(Long id){
		return boardRepository.findById(id).get();
	}
	
	public List<Board> findBoards(String name){
		return boardRepository.findAll();
	}
	
	public List<Board> findAll(){
		return boardRepository.findAll();
	}
}
