package com.iamlook;

import com.alibaba.fastjson.JSON;
import com.iamlook.model.User;
import com.iamlook.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private IUserService userService;

	private int threadCount=1;//线程数量

	private CountDownLatch countDown=new CountDownLatch(threadCount);//CountDownLatch

	@Test
	public void contextLoads() throws InterruptedException {
		for (int i = 0; i < threadCount; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					countDown.countDown();
					List result = userService.queryAll();
					System.out.println(JSON.toJSONString(result));
				}
			}).start();

		}
		countDown.await();
		System.out.println("线程全部执行结束");
	}

}
