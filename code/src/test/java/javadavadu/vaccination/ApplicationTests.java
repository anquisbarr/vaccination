package javadavadu.vaccination;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import controller.UserController;
import data.entities.User;
import data.dtos.UserDTO;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@Execution(ExecutionMode.CONCURRENT)
class ApplicationTests {
	static final Logger logger = Logger.getLogger(ApplicationTests.class.getName());
	@Autowired
	private UserController controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void validRequest() throws Exception{
		String url = "http://localhost:"+port+"/";
		Assertions.assertEquals(200,this.restTemplate.getForEntity(url, String.class).getStatusCodeValue());
	}

	@Test
	void getRequest() throws Exception{
		String url = "http://localhost:"+port+"/users/72789412";
		Assertions.assertEquals(200,this.restTemplate.getForEntity(url, String.class).getStatusCodeValue());
	}

	// @Test
	// void validPostRequest() throws Exception{
	// 	String url = "http://localhost:"+port+"/users/";
	// 	Calendar fechaNacimiento = new GregorianCalendar(2001,4,27);
	// 	User user = new User("76276532","Sebastian Andres",
	// 				"Quispe", "Barriga",fechaNacimiento,"999111000","squispe@utec.edu.pe");
	// 	Assertions.assertEquals(200,this.restTemplate.postForEntity(url,user,String.class).getStatusCodeValue());
	// }

	// @Test
	// void expectedTimeLimit(){
	// 	String url = "http://localhost:"+port+"/users/72789412";
	// 	long start = System.currentTimeMillis();
	// 	this.restTemplate.getForEntity(url, String.class);
    //     long end = System.currentTimeMillis();
    //     long duration = end - start;
    //     Assertions.assertTrue(duration <= 400);
	// }
	
	//@RepeatedTest(value=1000)
    @Test
	void testStress(){
		Calendar expectedResult = new GregorianCalendar(2022,2,4);
		Calendar result = controller.getFechaVacunacionById("70989898");
        Assertions.assertTrue(result.equals(expectedResult));
    }

}
