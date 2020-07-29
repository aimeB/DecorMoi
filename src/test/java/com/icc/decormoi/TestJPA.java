package com.icc.decormoi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestJPA {

	@Test
	void test1() {
		
		try {
			ClassPathXmlApplicationContext app=
	new ClassPathXmlApplicationContext(new String[] {"application.properties"});
			assertTrue(true);
			
	} catch (Exception e) {
			assertFalse(false);
	}
	
	}
	
}
