package com.dogboard.springboot.service.posts;


import com.dogboard.springboot.domain.posts.Posts;
import com.dogboard.springboot.domain.posts.PostsRespository;
import com.dogboard.springboot.web.dto.PostsResponseDto;
import com.dogboard.springboot.web.dto.PostsSaveRequestDto;
import com.dogboard.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class PostsService {

    private final PostsRespository postsRespository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRespository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRespository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다. id ="+id));

            posts.update(requestDto.getTitle(),requestDto.getContent());

            return id;
    }


    public PostsResponseDto findById(Long id)
    {
        Posts entity =postsRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);


    }
}
