package se.lexicon.week52_springai_chatbotapp_cvfeedback.service;

import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;

public interface CVFeedbackChatbotService {
    String summarizeResume(Resume resume);
}