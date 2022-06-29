package com.dogboard.springboot.web;

import com.dogboard.springboot.service.posts.PostsService;
import com.dogboard.springboot.web.dto.PostsResponseDto;
import com.dogboard.springboot.web.dto.PostsSaveRequestDto;
import com.dogboard.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor //생성자로 빈을 주입
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }




}
