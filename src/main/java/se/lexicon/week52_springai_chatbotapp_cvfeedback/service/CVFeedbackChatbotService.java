package se.lexicon.week52_springai_chatbotapp_cvfeedback.service;

import reactor.core.publisher.Flux;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;

public interface CVFeedbackChatbotService {
    String summarizeResumeChat(Resume resume);

    Flux<String> summarizeResumeReactiveChat(String resume);
}