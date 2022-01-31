package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄.
//Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK 필드임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK 의 생성규칙을 나타냄. GenerationType.IDENTITY 옵션을 줘야지 auto_increment 가 됨.
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼을 나타냄.(안써도 컬럼임)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder //빌더 패턴 클래스를 생성하겠다. 빌더 패턴 잘 모르겠음... 공부 해야함...
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }




}
