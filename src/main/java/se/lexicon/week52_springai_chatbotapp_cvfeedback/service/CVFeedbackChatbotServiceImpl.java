package se.lexicon.week52_springai_chatbotapp_cvfeedback.service;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.entity.Resume;

import java.util.List;

@Service
public class CVFeedbackChatbotServiceImpl implements CVFeedbackChatbotService {
    OpenAiChatModel openAiChatModel;

    @Autowired
    public CVFeedbackChatbotServiceImpl(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public String summarizeResume(Resume resume) {
        String systemText = """
                You are a helpful, concise and professional AI Assistant that accepts CV information as text and provides summarized feedback.
                Structure the response into clear sections: 'Strength', 'Weakness' and 'Areas of Improvement'.
                Maintain a friendly tone and ensure your feedback is relevant to the input.
                """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);
        Message systemMessage = systemPromptTemplate.createMessage();
        Prompt prompt = new Prompt(String.valueOf(List.of(resume.getCvInfo(), systemMessage)));
//        Flux<String> fluxResponse = Flux.fromStream(() -> openAiChatModel.stream(prompt)).map(ChatResponse::toString);
        return openAiChatModel.call(prompt).getResult().toString();
    }
}