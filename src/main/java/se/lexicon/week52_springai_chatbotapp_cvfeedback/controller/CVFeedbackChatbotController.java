package se.lexicon.week52_springai_chatbotapp_cvfeedback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.service.CVFeedbackChatbotServiceImpl;

@RestController
public class CVFeedbackChatbotController {
    CVFeedbackChatbotServiceImpl cvFeedbackChatbotService;

    @Autowired
    public CVFeedbackChatbotController(CVFeedbackChatbotServiceImpl cvFeedbackChatbotService) {
        this.cvFeedbackChatbotService = cvFeedbackChatbotService;
    }

    @PostMapping("/summarizeResume")
    public ResponseEntity<String> summarizeResume(@RequestBody @Valid Resume resume) {
        String response = cvFeedbackChatbotService.summarizeResume(resume);
        return ResponseEntity.ok(response);
    }
}