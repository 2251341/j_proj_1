package com.sbs.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    // mappedBy Answer 클래스의 question 변수 이름을 적어양 함.
    // CascadeType.REMOVE 하면 Question을 삭제 할 때 답변도 함께 삭제됨.
    // OneToMany는 테이블의 컬럼으로 생성되지 않음.
    // 선택
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
