package com.hooney.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor      //기본 생성자 자동 추가
@Entity                 //table과 링크될 클래스 명시, 언더스코어 네이밍(_)으로 테이블 이름 매칭
                        //Entity 클래스에서는 절대로 무분별한 Setter메소드 생성X
public class Posts {    //실제 DB테이블과 매칭될 클래스(Entity Class)
    @Id     //해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //PK 생성규칙 나타냄,
    private Long id;

    @Column(length = 500, nullable = false)                     //테이블의 컬럼, 선언하지 않아도 모든 필드는 컬럼이 됨
    private String title;                                       //기본값 외에 추가로 변경이 필요한 옵션이 있는 경우 사용

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //해당 클래스의 빌더패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
