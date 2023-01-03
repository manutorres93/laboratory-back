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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.reto.entity.Affiliates;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.service.AffiliatesService;
import com.example.reto.service.impl.AffiliatesServicesImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {
	
	@Autowired
	Affiliates affiliates;
	
	@InjectMocks
	AffiliatesController affiliatesTest= new AffiliatesController();
	
	@Mock
	AffiliatesService affiliatesServiceMock;
	AffiliatesRepository affiliatesRepositoryMock;
	
	@Autowired
	AffiliatesServicesImpl AffiliatesServiceImpl = new AffiliatesServicesImpl ();

	@Test
	void testConsultarAffiliates() {
		
		when (affiliatesServiceMock.getListAffiliates()).thenReturn (Collections.singletonList(null));		
		var response = affiliatesTest.getAllAffiliates();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarAffiliatesVacio() {
		
		when (affiliatesServiceMock.getListAffiliates()).thenReturn (Collections.emptyList());		
		var response = affiliatesTest.getAllAffiliates();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	void testGuardarAffiliate() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.saveAffiliate(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.saveAffiliate(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarAffiliateExcepcion() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.saveAffiliate(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.saveAffiliate(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarAffiliate() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.updateAffiliate(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.updateAffiliate(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarAffiliateExcepcion() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.updateAffiliate(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.updateAffiliate(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorId() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.getById(anyInt())).thenReturn(affiliates);
		
		var response = affiliatesTest.geyById(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorIdNotFound() {
		
		Affiliates affiliates= new Affiliates();
		int numero=1;
		
		when(affiliatesServiceMock.getById(numero)).thenReturn(affiliates);
		
		var response = affiliatesTest.geyById(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testEliminarAfiliado() {

		doNothing().when(affiliatesServiceMock).deleteAffiliate(anyInt());		
		var response = affiliatesTest.deleteAffiliate(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testEliminarAfiliadoNoEncontrado() {
		
		int numero=1;

		doNothing().when(affiliatesServiceMock).deleteAffiliate(numero);		
		var response = affiliatesTest.deleteAffiliate(anyInt());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	


}
