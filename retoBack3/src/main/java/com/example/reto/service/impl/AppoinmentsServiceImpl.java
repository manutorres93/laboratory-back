/**
 * 
 */
package com.example.reto.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.repository.AppoinmentsRepository;
import com.example.reto.service.AppointmentsService;

/**
  *Clase que implementa los metodos de logica de negocio de la inteface de AppoinmentsService
 */

@Service
public class AppoinmentsServiceImpl implements AppointmentsService {
	
	@Autowired
	private AppoinmentsRepository appoinmentsRepository;

	@Override
	public List<Appointments> getListAppointments() {
		List <Appointments> appointmentDataSource = StreamSupport.stream(
				this.appoinmentsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return appointmentDataSource;
	}

	
	@Override
	public Appointments saveAppointment(Appointments appointment) {
				
		return this.appoinmentsRepository.save(appointment);
		
	}

	@Override
	public Appointments updateAppointment(int id, Appointments appointment) {		
		Appointments existingAppointment = appoinmentsRepository.findById(id).get();
		
		if (appointment.getDate()!= null) {
			existingAppointment.setDate(appointment.getDate());
		}
		
		if (appointment.getHora()!= null) {
			existingAppointment.setHora(appointment.getHora());
		}
		
		if (appointment.getIdAffiliate()!= null) {
			existingAppointment.setIdAffiliate(appointment.getIdAffiliate());
		}
		
		if (appointment.getIdTest()!= null) {
			existingAppointment.setIdTest(appointment.getIdTest());
		}
		
		return this.appoinmentsRepository.save(existingAppointment);
	}

	@Override
	public void deleteAppointment(int id) {
		this.appoinmentsRepository.deleteById(id);

	}

	@Override
	public Appointments getById(int id) {
		return this.appoinmentsRepository.findById(id).get();
	}

	@Override
	public List<Appointments> findByIdAffiliate(Affiliates idAffiliate) {
		return this.appoinmentsRepository.findByIdAffiliate(idAffiliate);
	}

	@Override
	public List<Appointments> findByDateOrderByIdAffiliateAsc(String date) {
		LocalDate appointmentTime = LocalDate.parse(date);
		return this.appoinmentsRepository.findByDateOrderByIdAffiliateAsc(appointmentTime);
	}


	
	}

	

