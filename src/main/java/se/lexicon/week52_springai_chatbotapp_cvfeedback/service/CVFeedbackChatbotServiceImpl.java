package se.lexicon.week52_springai_chatbotapp_cvfeedback.service;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;

import java.util.List;
import java.util.Optional;

@Service
public class CVFeedbackChatbotServiceImpl implements CVFeedbackChatbotService {
    OpenAiChatModel openAiChatModel;

    @Autowired
    public CVFeedbackChatbotServiceImpl(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public String summarizeResumeChat(Resume resume) {
        String systemText = """
                You are a helpful and professional AI Assistant that accepts CV information as text and provides summarized feedback.
                Structure the response into clear sections: 'Strength', 'Areas of Improvement' and 'Weakness'.
                Respond with a concise message in each section.
                No need to add more text or message and Not more that 3 points in each section.
                Maintain a friendly tone and ensure your feedback is relevant to the input.
                """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);
        Message systemMessage = systemPromptTemplate.createMessage();
        Prompt prompt = new Prompt(String.valueOf(List.of(resume.getCvInfo(), systemMessage)));
        ChatResponse chatResponse = openAiChatModel.call(prompt);
        Generation result = chatResponse.getResult();
        return result.getOutput().getContent();
    }

    @Override
    public Flux<String> summarizeResumeReactiveChat(String resume) {
        String systemText = """
                You are a helpful and professional AI Assistant that accepts CV information as text and provides summarized feedback.
                Structure the response into clear sections: 'Strength', 'Areas of Improvement' and 'Weakness'.
                Respond with a concise message in each section.
                No need to add more text or message and Not more that 3 points in each section.
                Maintain a friendly tone and ensure your feedback is relevant to the input.
                """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);
        Message systemMessage = systemPromptTemplate.createMessage();
        Prompt prompt = new Prompt(String.valueOf(List.of(resume, systemMessage)));
        Flux<ChatResponse> chatResponse = openAiChatModel.stream(prompt);
        return chatResponse.map(response -> Optional.ofNullable(response.getResult().getOutput().getContent()).orElse("default"));
    }
}