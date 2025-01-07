package se.lexicon.week52_springai_chatbotapp_cvfeedback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.service.CVFeedbackChatbotServiceImpl;

@RestController
@RequestMapping("/api/summarizeResume")
public class CVFeedbackChatbotController {
    CVFeedbackChatbotServiceImpl cvFeedbackChatbotService;

    @Autowired
    public CVFeedbackChatbotController(CVFeedbackChatbotServiceImpl cvFeedbackChatbotService) {
        this.cvFeedbackChatbotService = cvFeedbackChatbotService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> summarizeResume(@RequestBody @Valid Resume resume) {
        String response = cvFeedbackChatbotService.summarizeResumeChat(resume);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/reactiveChat")
    public ResponseEntity<Flux<String>> summarizeResume(@RequestParam @Valid String resume) {
        Flux<String> response = cvFeedbackChatbotService.summarizeResumeReactiveChat(resume);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}