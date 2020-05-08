package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("SELECT p FROM Post p ORDER BY p.createDateTime DESC")
	public List<Post> findAllDesc();

}
