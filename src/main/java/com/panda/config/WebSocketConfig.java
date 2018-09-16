package com.panda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * websocket配置类
 */
//？？？这个配置类的作用？为什么把下面@bBean注释掉，使用websocket时会报websocket通信错误？
@Component
public class WebSocketConfig {
    @Bean     //？？？为什么这个地方会在单元测试时报错？
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
