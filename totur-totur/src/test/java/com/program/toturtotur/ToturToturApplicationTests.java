package com.program.toturtotur;

import com.program.toturtotur.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToturToturApplicationTests {


	@Autowired
	StudentServiceImpl studentService;

	@Test
	public void contextLoads() {
	}

}
