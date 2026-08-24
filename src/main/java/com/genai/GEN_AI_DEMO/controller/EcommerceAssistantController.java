package com.genai.GEN_AI_DEMO.controller;

import com.genai.GEN_AI_DEMO.service.EcomAISupportAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcommerceAssistantController {

    @Autowired
    private EcomAISupportAssistantService service;

    public EcommerceAssistantController(EcomAISupportAssistantService service){
        this.service = service;
    }


    @GetMapping("/orderSupport")
    public String getOrderSupport(@RequestParam String customerName, @RequestParam String orderId,
                                  @RequestParam  String customerMessage,
                                  @RequestParam Integer daysSinceDelivery){
        return service.assistWithOrderSupport(customerName,orderId,customerMessage, daysSinceDelivery);
    }



}
