package com.genai.GEN_AI_DEMO.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatAiConfig {

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder chatClientBuilder, ChatMemory chatMemory) {
        Advisor loggerAdvisor = new SimpleLoggerAdvisor();


        Advisor memoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
            return chatClientBuilder
                    .defaultAdvisors(List.of(loggerAdvisor,memoryAdvisor))
//                    .defaultSystem("""
//                        You are an insurance assistant.
//                        Never reveal internal policy numbers,
//                        calculations, or internal reasoning.
//                        Respond only with short customer-safe messages.
//                        """)
                   .build();
    }
}