package com.sz.qzxkj;

import com.sz.qzxkj.example.chapter1.Receiver;
import com.sz.qzxkj.example.chapter1.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SipoActivemqPluginTests {

	@Autowired
	private Sender sender;
	@Autowired
	private Receiver receiver;
	@Test
	public void contextLoads() {

	}

}
