package com.iamlook.controller;

import com.iamlook.kafka.KafkaProducerService;
import com.iamlook.response.BaseResponse;
import com.iamlook.response.Feed;
import com.iamlook.response.FeedVo;
import com.iamlook.response.OriginalInput;
import com.iamlook.response.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 11:01
 **/
@RequestMapping(value = "/kafka")
@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public BaseResponse<String> addUser(@RequestBody @Valid UserRequest ur) {
        kafkaProducerService.send(ur);
        return BaseResponse.success(null);
    }

    @PostMapping("/sendFeed")
    public BaseResponse<String> sendFeed(@RequestBody @Valid FeedVo feed, HttpServletRequest request) {
        kafkaProducerService.send(feed);
        System.out.println(getIpAddr(request));
        return BaseResponse.success(null);
    }


    @PostMapping("/sendFlink")
    public BaseResponse<String> sendFlink(@RequestBody @Valid OriginalInput input, HttpServletRequest request) {
        input.setTime(new Date().getTime() + (int)(Math.random()*(100-1+1)));
        kafkaProducerService.send(input);
        System.out.println(getIpAddr(request));
        return BaseResponse.success(null);
    }
    @PostMapping("/sendFlinkConfig")
    public BaseResponse<String> sendFlinkConfig(@RequestBody @Valid Feed feed, HttpServletRequest request) {
        kafkaProducerService.sendFlinkConfig(feed);
        System.out.println(getIpAddr(request));
        return BaseResponse.success(null);
    }




    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
/*

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.setId("6395616c-afdf-4e9f-962b-ca5db6c47027");
        feed.setDeviceId("6395616c-afdf-4e9f-962b-ca5db6c88888");
        feed.setFeedNum("9");
        feed.setInputId("6395616c-afdf-4e9f-962b-ca5db6c99999");
        feed.setIntervalUnitType(IntervalUnitType.HOUR);
        feed.setIntervalValue(990D);
        feed.setLastValue(new BigDecimal(1000));
        feed.setName("温度");
        feed.setNum(1);
        feed.setUnit("°C");
        feed.setUnitId("6395616c-afdf-4e9f-962b");
        feed.setUpdateTime(LocalDateTime.now());

        System.out.println(JSON.toJSONString(feed));
    }
*/



}
