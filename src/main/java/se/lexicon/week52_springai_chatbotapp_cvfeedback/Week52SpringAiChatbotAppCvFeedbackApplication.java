package se.lexicon.week52_springai_chatbotapp_cvfeedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import se.lexicon.week52_springai_chatbotapp_cvfeedback.config.OpenAIProperties;

@SpringBootApplication
public class Week52SpringAiChatbotAppCvFeedbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week52SpringAiChatbotAppCvFeedbackApplication.class, args);
    }

}