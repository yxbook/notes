/*
package com.iamlook.controller;

import com.iamlook.websocket.socket.impl.ScoketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/***************************************
 * @Project cabinet-java
 * @Description
 * @Author yx
 * @Date 19-6-24
 * @Version 1.0
 ***************************************//*

@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    private ScoketClient webScoketClient;

    @GetMapping("/sendMessage")
    public String sendMessage(String message){
        webScoketClient.groupSend(message);
        return message;
    }


}
*/
