package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
