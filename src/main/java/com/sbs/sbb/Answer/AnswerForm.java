package com.sbs.sbb.Answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotBlank(message = "내용은 필수항목입니다.")
    @Size(max = 200, message = "내용을 200자 이내로 적어주시요")
    private String content;
}
