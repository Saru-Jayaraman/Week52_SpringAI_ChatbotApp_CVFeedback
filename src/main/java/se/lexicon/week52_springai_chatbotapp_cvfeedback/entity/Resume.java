package se.lexicon.week52_springai_chatbotapp_cvfeedback.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resume {
    @NotBlank(message = "CV Information is required")
    private String cvInfo;
}