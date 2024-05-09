package com.sbs.sbb.Answer;


import com.sbs.sbb.Question.Question;
import com.sbs.sbb.Question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer") // 접두어(앞에 들어가는단어)
@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content){
        Question q = this.questionService.getQuestion(id); //id 가져옴

        Answer answer = this.answerService.create(q,content);

        return "redirect:/question/detail/%s".formatted(id);
    }
}
