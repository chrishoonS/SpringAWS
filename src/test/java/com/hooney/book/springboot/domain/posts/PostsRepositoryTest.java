package com.hooney.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After  //단위 테스트 끝날때마다 수행되는 메소드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // postsRepository.save : 테이블 posts에 insert/update 쿼리 수행
        // id값이 있다면 update, 없으면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hooney1103@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();  //table posts에 모든 데이터 조회하는 메서드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}