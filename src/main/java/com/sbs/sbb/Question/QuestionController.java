package com.sbs.sbb.Question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);

        return "question_detail";
    }

    @GetMapping("/create")
    public String create() {
        return "question_form";
    }

    @PostMapping("/create")
    // QuestionForm 값을 바인딩 할 때 유효성 체크를 하라!!
//    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
    public String questionCreate(@Valid QuestionForm questionForm){

        Question q = this.questionService.create(questionForm.getSubject(), questionForm.getSubject());

        return "redirect:/question/list";
    }
}