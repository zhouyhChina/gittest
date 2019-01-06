package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybootApplicationTests {
	@Resource
	MailService mailService;
	@Test
	public void contextLoads() {
		mailService.senSimpleMail("554274200@qq.com", "my first springbootmail", "hello world!");
	}

}
