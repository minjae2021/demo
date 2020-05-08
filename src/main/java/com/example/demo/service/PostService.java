package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	public void savePost(Post post) {
		postRepository.save(post);
	}
	
	public List<Post> findAll() {
		return postRepository.findAllDesc();
	}
	
	public Post findOne(Long postId) {
		return postRepository.findById(postId).get();
	}
	
	@Modifying
	@Transactional
	public void updatePost(Long postId, String title, String content, String writer) {
		Post post = postRepository.findById(postId).get();
		post.setTitle(title);
		post.setContent(content);
		post.setWriter(writer);
	}
	
	/*
	 * 페이징
	 */
	/*public Page<Post> getPagingPost(Pageable pageable){
		int page = (pageable.getPageNumber()==0) ? 0 : (pageable.getPageNumber()-1);
		//page 0부터 시작
		pageable = PageRequest.of(page, 5);
		return postRepository.findAll(pageable);
	}*/
	
	/*
	 *desc 
	 */
	public Page<Post> getPagingPost(Pageable pageable){
		int page = (pageable.getPageNumber()==0) ? 0 : (pageable.getPageNumber()-1);
		//page 0부터 시작
		pageable = PageRequest.of(page, 5,Sort.by("createDateTime").descending());
		return postRepository.findAll(pageable);
	}
	
	/*
	 * asc
	 */
	public Page<Post> getPagingPostAsc(Pageable pageable){
		int page = (pageable.getPageNumber()==0)? 0 : (pageable.getPageNumber()-1);
		pageable = PageRequest.of(page, 5);
		return postRepository.findAll(pageable);
	}
}
