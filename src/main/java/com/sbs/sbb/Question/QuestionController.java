package com.sbs.sbb.Question;

import com.sbs.sbb.Answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);

        return "question_detail";
    }

    @GetMapping("/create")
    // Question 변수는 model.addAttribute 없이 바로 뷰에서 접근할 수 있다.

    public String create(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    // QuestionForm 값을 바인딩 할 때 유효성 체크를 하라!!
//    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // question_form.html 실행
            // 다시 작성 하라는 의미로 돌려보냄
            return "question_form";
        }
        Question q = this.questionService.create(questionForm.getSubject(), questionForm.getSubject());

        return "redirect:/question/list";
    }
}