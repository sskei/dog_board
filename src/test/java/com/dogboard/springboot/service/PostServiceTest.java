package com.dogboard.springboot.service;
import com.dogboard.springboot.domain.posts.Posts;
import com.dogboard.springboot.domain.posts.PostsRepository;
import com.dogboard.springboot.service.posts.PostsService;
import com.dogboard.springboot.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;





    /**
     * Created by jojoldu@gmail.com on 2018. 1. 1.
     * Blog : http://jojoldu.tistory.com
     * Github : https://github.com/jojoldu
     */

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class PostServiceTest {

        @Autowired
        private PostsService postsService;

        @Autowired
        private PostsRepository postsRepository;

        @After
        public void cleanup () {
            postsRepository.deleteAll();
        }

        @Test
        public void Dto데이터가_posts테이블에_저장된다 () {
            //given
            PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                    .author("jojoldu@gmail.com")
                    .content("테스트")
                    .title("테스트 타이틀")
                    .build();

            //when
            postsService.save(dto);

            //then
            Posts posts = postsRepository.findAll().get(0);
            assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
            assertThat(posts.getContent()).isEqualTo(dto.getContent());
            assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        }
    }

