package com.sbs.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity //answer 테이블
public class Answer {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(columnDefinition = "TEXT") //text
    private String content;

    private LocalDateTime createDate;

    //Many = Answer, one = Question
    //필수                           private Integer questionId;
    @ManyToOne // question을 쓸 때 달아줘야 한다.
    private Question question;



}
