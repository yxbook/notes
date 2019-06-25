package com.iamlook.websocket.client;

import org.java_websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

/***************************************
 * @Project cabinet-java
 * @Description
 * @Author yx
 * @Date 19-6-24
 * @Version 1.0
 ***************************************/
@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);


    @GetMapping("/sendMessage")
    public String sendMessage(String message) throws URISyntaxException {
        CWebSocketClient client = new CWebSocketClient("ws://127.0.0.1:8080/websocket/admin");
        client.connect();
        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
            LOGGER.info("[websocket]正在建立连接......");
        }
        LOGGER.info("[websocket]建立连接成功");
        client.send(message);
        return "OK";
    }


}
