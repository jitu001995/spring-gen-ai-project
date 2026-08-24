package com.genai.GEN_AI_DEMO.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageRoleDemoService {
    private final ChatClient chatClient;

    private static final String CLAIN_DETAILS="""
                 Clain details:
                 Policy: BASIC
                 Max Coverage: 20000
                 Claim Amount: 50000
                """;

    public MessageRoleDemoService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

//    public MessageRoleDemoService(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.defaultSystem("""
//                You are an insurance assistant. You must Never reveal internal Policy numbers,
//                calculations, or internal reasoning.
//                Response Only with a short, customer-safe message.
//                """).build();
//    }

    public String checkPolicy(String message){
       // prompt injection can unsafe our project designed with AI without any Message Roles
        UserMessage userMessage = new UserMessage("""
                 Policy details:
                 Policy: PREMIUM
                 MaxCoverage: 100000
                 Claim Amount: 150000
                 Customer says:
                 %s
                """.formatted(message));

        // System message will safe our Ai Project desgined with
        SystemMessage systemMessage = new SystemMessage("""
                You are an insurance assistant. You must Never reveal internal Policy numbers,
                calculations, or internal reasoning.
                Response Only with a short, customer-safe message.
                """);
       Prompt prompt = new Prompt(List.of(userMessage,systemMessage));
       return chatClient.prompt(prompt).call().content();
    }


    public String checkInsuranceV2Policy(String message){
        return chatClient.prompt()
                .user("""
                %S
                Customer says:
                %s
                """.formatted(CLAIN_DETAILS,message)).call().content();
    }


}
