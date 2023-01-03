/**
 * 
 */
package com.example.reto.service;



import java.util.List;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;


public interface AppointmentsService {
	

	List<Appointments> getListAppointments();
	
	Appointments saveAppointment(Appointments appointment);

	Appointments updateAppointment (Appointments appointment);
		
	void deleteAppointment (int id);
	
	Appointments getById (int id);
	
	List<Appointments> findByDateOrderByIdAffiliateAsc(String date);
	
	List<Appointments> findByIdAffiliate(Affiliates idAffiliate);
}