package com.iamlook.controller;

import com.iamlook.kafka.KafkaProducerService;
import com.iamlook.response.BaseResponse;
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



}
