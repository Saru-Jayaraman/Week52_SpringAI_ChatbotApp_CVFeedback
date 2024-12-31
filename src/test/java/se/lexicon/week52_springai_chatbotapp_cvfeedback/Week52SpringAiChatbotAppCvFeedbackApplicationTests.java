package se.lexicon.week52_springai_chatbotapp_cvfeedback;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.config.OpenAIProperties;

@SpringBootTest
class Week52SpringAiChatbotAppCvFeedbackApplicationTests {
    @Autowired
    OpenAIProperties openAIProperties;

    @Test
    void contextLoads() {
    }
}