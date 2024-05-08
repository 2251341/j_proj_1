package com.sbs.sbb.Question;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question") // 접두어(앞에 들어가는단어)
@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;


    @GetMapping("/list")
    public  String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";


    }
    @GetMapping("/detail/{id}")
    public  String detail(Model model, @PathVariable("id") Integer id) {
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);
        return "question_detail";


    }
}
