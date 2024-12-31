## AI DRIVEN CHATBOT APPLICATION FOR CV FEEDBACK:
* Generative AI Powered Application is the integration of Spring AI Framework with Spring Boot Application.
* Integration of Artificial Intelligence and Machine Learning into Spring-based application.
* Spring AI project aims to simplify the development of applications that incorporate artificial intelligence functionality without unnecessary complexity.
* This technique was introduced to help the developers in connecting with LLM for decision-making, solving task etc.

## OBJECTIVE:
Task is to create AI CHATBOT App for providing CV Feedback having Java Spring boot application as backend which connects with the AI technologies.

### **`Input:`** Resume Information
### **`Spring boot application:`** Already configured with System instructions and LLM parameter Settings.
### **`Output:`** Summarized feedback with Strength, Weakness and Areas of Improvement.

### STEPS implemented in Spring Boot Application:
1. Spring boot application is created with Gradle as build automation tool. Necessary dependencies are added.
2. Properties file:
    * Spring application connects with Open AI's predefined model gpt-4o.
    * Added the necessary configuration properties to connect with Open AI model (baseurl, model name, max-attempts and API key).
      API Key is added as environmental variable.
    * System Information is configured inside the Spring boot application.
    * Configured the necessary LLM Fine Tune options to customize the model response.
3. Controller and Service classes are created. Taken necessary actions to implement the following API endpoints inside these classes.
    * OpenAiChatModel class which has pre-built methods to connect with Open AI Model is used in Service class.
    * Interact with AI functionalities using APIs like AI Model API and Advisors API.
      API Chat Endpoint is created.
    1. Chat Model - Synchronous which is a blocking one.
        - Response is delivered to the user only when the request sent to predefined model is processed completely.
        - User and Application has to wait until the response is generated fully.
    2. SystemPromptTemplate, Message and Prompt(Predefined Classes present inside org.springframework.ai.chat) are used in adding System instructions, sending request to and receiving response from Open AI chat model.