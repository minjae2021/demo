package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final PostService postService;

	/*@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("posts",postService.findAll());
		return "post";
	}*/
	
}
