package com.iamlook.websocket.client;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

/***************************************
 * @Project cabinet-java
 * @Description  websocket客户端
 * @Author yx
 * @Date 19-6-25
 * @Version 1.0
 ***************************************/


public class CWebSocketClient extends WebSocketClient{

    private static final Logger LOGGER = LoggerFactory.getLogger(CWebSocketClient.class);


    public CWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        LOGGER.info("[websocket] 握手成功");
        for(Iterator<String> it=shake.iterateHttpFields();it.hasNext();) {
            String key = it.next();
            LOGGER.info("[websocket]" + key+":"+shake.getFieldValue(key));
        }
    }

    @Override
    public void onMessage(String message) {
        LOGGER.info("[websocket] 收到消息={}",message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        LOGGER.info("[websocket] 退出连接Code={},reason={},remote={}", code, reason, remote);
    }

    @Override
    public void onError(Exception e) {
        LOGGER.info("[websocket] 连接错误={}",e.getMessage());

    }
}