package com.genai.GEN_AI_DEMO.service;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.stereotype.Service;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;


@Service
public class OpenAiChatService {

//    private final ChatClient chatClient;
//
//    public OpenAiChatService(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }

    private final ChatClient chatClient;

    public OpenAiChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chatWithOpenAILLM(String message, String username) {
        return chatClient.prompt()
                .user(message)
                .advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID,username))
                .call()
                .content();
    }
}
