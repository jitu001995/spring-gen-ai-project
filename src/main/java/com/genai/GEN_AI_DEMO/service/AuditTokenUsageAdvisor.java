package com.genai.GEN_AI_DEMO.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;


public class AuditTokenUsageAdvisor implements CallAdvisor {
   Logger logger = LoggerFactory.getLogger(AuditTokenUsageAdvisor.class);
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain){
     // call the next advisor
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        ChatResponse chatResponse = chatClientResponse.chatResponse();
        // Audit token usage here
        if(chatResponse !=null) {
            Usage usage = chatResponse.getMetadata().getUsage();
            if (usage != null) {
                int inputToken = usage.getPromptTokens();
                int outputToken = usage.getCompletionTokens();
                int totalToken = usage.getTotalTokens();

                logger.info("Token Usage - input Tokens : {}, output Tokens: {}, Total Tokens : {}", inputToken, outputToken, totalToken);
            }
        }

        // extract (i/p token, o/p token, total token)
        return null;
    }

    @Override
    public String getName(){
      return "AuditTokenUsageAdvisor";
    }

    @Override
   public int getOrder(){
     return 0;
    }

}
