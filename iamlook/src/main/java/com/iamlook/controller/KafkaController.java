package com.iamlook.controller;

import com.iamlook.kafka.KafkaProducerService;
import com.iamlook.response.BaseResponse;
import com.iamlook.response.Feed;
import com.iamlook.response.FeedVo;
import com.iamlook.response.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public BaseResponse<String> sendFeed(@RequestBody @Valid FeedVo feed) {
        kafkaProducerService.send(feed);
        return BaseResponse.success(null);
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
