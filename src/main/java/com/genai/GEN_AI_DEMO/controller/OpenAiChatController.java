package com.genai.GEN_AI_DEMO.controller;


import com.genai.GEN_AI_DEMO.service.MessageRoleDemoService;
import com.genai.GEN_AI_DEMO.service.OpenAiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")
public class OpenAiChatController {

    @Autowired
    private OpenAiChatService openAiChatService;

    @Autowired
    private  MessageRoleDemoService messageRoleService;

    @GetMapping("/chat")
    public String chat(@RequestParam String message, @RequestParam  String username){
        return openAiChatService.chatWithOpenAILLM(message,username);
    }

    @GetMapping("/check/policy")
    public String checkPolicy(@RequestParam String message){
      // return messageRoleService.checkPolicy(message);
        return messageRoleService.checkInsuranceV2Policy(message);
    }

}
