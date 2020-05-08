package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@Controller
public class PostController {
	
	@Autowired PostService postService;
	
	@GetMapping("/post/list")
	public String post(Model model) {
		List<Post> posts = postService.findAll();
		model.addAttribute("posts",posts);
		return "post";
	}
	
	@GetMapping("/post/new")
	public String createForm(Model model) {
		model.addAttribute("form",new PostForm());
		return "write";
	}
	
	/*@PostMapping("/post/new")
	public String create(@Valid PostForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("form",form);
			return "write";
		}
		Post post = new Post();
		post.setTitle(form.getTitle());
		post.setContent(form.getContent());
		post.setWriter(form.getWriter());
		postService.savePost(post);
		return "redirect:/";
	}*/
	
	@PostMapping("/post/new")
	public String create(@Valid PostForm form, BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "write";
		}
		Post post = new Post();
		post.setTitle(form.getTitle());
		post.setContent(form.getContent());
		post.setWriter(form.getWriter());
		postService.savePost(post);
		return "redirect:/";
	}
	
	@GetMapping(value="/post/{postId}/update")
	public String updateForm(@PathVariable("postId") Long postId, Model model) {
		Post post = postService.findOne(postId);
		PostForm form = new PostForm();
		form.setTitle(post.getTitle());
		form.setContent(post.getContent());
		form.setWriter(post.getWriter());
		model.addAttribute("form",form);
		return "post-update";
	}
	
	@PostMapping(value="/post/{postId}/update")
	public String update(@PathVariable("postId") Long postId,PostForm form) {
		postService.updatePost(postId, form.title, form.content, form.writer);
		return "redirect:/";
	}
	
	/*
	 * home
	 */
	@GetMapping("/")
	public String pagingPost(@PageableDefault Pageable pageable, Model model) {
		Page<Post> pagingPost = postService.getPagingPost(pageable);
		model.addAttribute("sort",new SortForm());
		model.addAttribute("posts",pagingPost);
		return "post";
	}
	
	@PostMapping("/paging")
	public String pagingPostSort(@PageableDefault Pageable pageable, SortForm sort, Model model) {
		if(sort.getSortString().equals("desc")) {
			Page<Post> pagingPost = postService.getPagingPost(pageable);
			model.addAttribute("posts",pagingPost);
			System.out.println("desc");
		}
		else {
			Page<Post> pagingPost = postService.getPagingPostAsc(pageable);
			model.addAttribute("posts",pagingPost);
			System.out.println("asc");
		}
		return "post";
	}
	
	@GetMapping("/asc")
	public String pagingPostAsc(@PageableDefault Pageable pageable, Model model) {
		Page<Post> pagingPost = postService.getPagingPostAsc(pageable);
		model.addAttribute("posts",pagingPost);
		return "post-asc";
	}
}
