package com.example.reto.controllers;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import com.example.reto.entity.TestLab;
import com.example.reto.service.TestService;



@ExtendWith(MockitoExtension.class)
class TestControllerTest {

	
	@Mock
	TestService testServiceMock;
	
	@InjectMocks
	TestController testTest;
			

		
	@Test
	void testConsultarTestVacio() {
		
		when (testServiceMock.getListTest()).thenReturn (Collections.emptyList());
		
		var response = testTest.getAllTest();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	

	@Test
	void testConsultarTest() {
	
		when (testServiceMock.getListTest()).thenReturn (Collections.singletonList(null));		
		var response = testTest.getAllTest();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testGuardarTest() {
		
		TestLab test= new TestLab();
		
		when(testServiceMock.saveTest(test)).thenReturn(test);
		
		var response = testTest.saveTest(test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarTestExcepcion() {
		TestLab test= new TestLab();
		
		when(testServiceMock.saveTest(test)).thenReturn(test);
		
		var response = testTest.saveTest(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarTest() {
		TestLab test= new TestLab();
		int numero=1;
		
		when(testServiceMock.updateTest(numero, test)).thenReturn(test);
		
		var response = testTest.updateTest(numero,test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarTestExcepcion() {
		
		TestLab test= new TestLab();
		int numero=1;
		int numero2=2;
		when(testServiceMock.updateTest(numero,test)).thenReturn(test);
		
		var response = testTest.updateTest(numero2, test);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarById() {
		
		TestLab test= new TestLab();
				
		when(testServiceMock.getById(anyInt())).thenReturn(test);
		
		var response = testTest.findById(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarByIdNotFound() {
		
		TestLab test= new TestLab();
		int numero=1;
				
		when(testServiceMock.getById(numero)).thenReturn(test);
		
		var response = testTest.findById(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testEliminarTest() {

		doNothing().when(testServiceMock).deleteTest(anyInt());		
		var response = testTest.deleteTest(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testEliminarTestNotFound() {
		
		int numero=1;

		doNothing().when(testServiceMock).deleteTest(numero);		
		var response = testTest.deleteTest(anyInt());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}


}
