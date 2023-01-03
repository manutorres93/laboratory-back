package com.example.reto.controllers;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.service.AppointmentsService;
import com.example.reto.service.impl.AppoinmentsServiceImpl;

@ExtendWith(MockitoExtension.class)
class AppoinmentsControllerTest {
	
//	@Autowired
//	TestLab test;
//	
	@Autowired
	Affiliates affiliates;
//		
//	@Autowired
//	Appointments appoinmentsMock;

	@InjectMocks
	AppoinmentsController appoinmentsTest= new AppoinmentsController ();
	
	@Mock
	AppointmentsService appoinmentServiceMock;
//	AppoinmentsServiceImpl appoinmentServiceImplMock;
//	AppoinmentsRepository appoinmentRepositoryMock;
	
	@Autowired
	AppoinmentsServiceImpl appoinmentsServiceImpl = new AppoinmentsServiceImpl();
	
	
	
	@Test
	void testConsultarAppoinmentVacio() {
		//fail("Not yet implemented");
		when (appoinmentServiceMock.getListAppointments()).thenReturn (Collections.emptyList());
		var response = appoinmentsTest.getAllAppointments();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	void testConsultarAppoinment() {
		
		
		when (appoinmentServiceMock.getListAppointments()).thenReturn (Collections.singletonList(null));		
		var response = appoinmentsTest.getAllAppointments();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testGuardarAppoinment() {

		Appointments appoinment= new Appointments();
		when (appoinmentServiceMock.saveAppointment(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.saveAppointment(appoinment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarAppoinmentExcepcion() {

		Appointments appoinment= new Appointments();
		when (appoinmentServiceMock.saveAppointment(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.saveAppointment(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarAppoinment() {

		Appointments appoinment= new Appointments();
		when (appoinmentServiceMock.updateAppointment(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.updateAppointment(appoinment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarAppoinmentExcepcion() {

		Appointments appoinment= new Appointments();
		when (appoinmentServiceMock.updateAppointment(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.updateAppointment(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorId() {

		Appointments appoinment= new Appointments();
		when (appoinmentServiceMock.getById(anyInt())).thenReturn(appoinment);		
		var response = appoinmentsTest.getById(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorIdNotFound() {

		int numero=1;
		when (appoinmentServiceMock.getById(numero)).thenReturn(null);		
		var response = appoinmentsTest.getById(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testfindByIdAffiliate() {
		
		when (appoinmentServiceMock.findByIdAffiliate(affiliates)).thenReturn 
		(Collections.singletonList(null));		
		
		var response = appoinmentsTest.getByIdAffiliate(affiliates);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	

	@Test
	void findByDateOrderByIdAffiliateAsc()  {
		
		when (appoinmentServiceMock.findByDateOrderByIdAffiliateAsc(anyString())).thenReturn 
		(Collections.singletonList(null));		
		
		var response = appoinmentsTest.getByDate(anyString());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@Test
	void testEliminarCita() {

		doNothing().when(appoinmentServiceMock).deleteAppointment(anyInt());		
		var response = appoinmentsTest.deleteAppointment(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testEliminarCitaNoEncontrada() {
		
		int numero=1;

		doNothing().when(appoinmentServiceMock).deleteAppointment(numero);		
		var response = appoinmentsTest.deleteAppointment(anyInt());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	

}
