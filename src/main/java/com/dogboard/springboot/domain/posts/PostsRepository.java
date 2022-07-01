package com.dogboard.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//db 접근자
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
