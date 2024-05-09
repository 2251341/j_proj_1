package com.sbs.sbb.Question;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("question", q); //모델을 통해 보내줌
        return "question_detail";
    }
    @GetMapping("/create")
    public String create() {
        return "question_form";
    }
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        Question q = this.questionService.create(subject, content);

        return "redirect:/question/list";
    }


}
