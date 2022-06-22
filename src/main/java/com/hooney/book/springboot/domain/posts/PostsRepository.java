package com.hooney.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /**
     * DAO := DB Layter 접근자
     * JpaRepository<Entity Class, PK type>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
     * @Repository를 추가할 필요도 없음
     * Entity 클래스와 Entity Repository는 같은 위치에 있어야함!
     * Repository없이는 Entity 클래스는 제대로 역할을 없음
     **/
}
