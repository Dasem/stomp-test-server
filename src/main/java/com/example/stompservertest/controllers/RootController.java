package com.example.stompservertest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/send")
    public String processMessage(@RequestParam String message) {
        messagingTemplate.convertAndSend("/topic/test",
               message);
        return message;
    }
}
