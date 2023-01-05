/**
 * 
 */
package com.example.reto.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.service.AppointmentsService;


@RestController
@RequestMapping ("/appointments")
public class AppoinmentsController {
	
	@Autowired
	private AppointmentsService appoinmentsServiceImpl;
	
	
	
	@GetMapping
	public ResponseEntity<?> getAllAppointments() {
		
			List<Appointments> appointmentGet = this.appoinmentsServiceImpl.getListAppointments();
			
			if (appointmentGet.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
			
			return ResponseEntity.ok(appointmentGet);
			}
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<?> saveAppointment(@RequestBody Appointments appointment) {
		
		try {
			Appointments savedAppointment= this.appoinmentsServiceImpl.saveAppointment(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
	}
	
	
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> updateAppointment(@PathVariable ("id") int id,@RequestBody Appointments appointment){
		
		try {
			Appointments updatedAppointment= this.appoinmentsServiceImpl.updateAppointment(id, appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(updatedAppointment);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@RequestMapping (value ="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointment(@PathVariable int id){
	
	
		try {
			this.appoinmentsServiceImpl.deleteAppointment(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		}
		
	@GetMapping ("/idAffiliate/{idAffiliates}")
	//@RequestMapping (value=  "/idAffiliate/{idAffiliates}", method = RequestMethod.GET)
	public ResponseEntity <List<Appointments>>getByIdAffiliate (@PathVariable ("idAffiliates")Affiliates idAffiliates){
		
		return new ResponseEntity <List<Appointments>>(this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates), HttpStatus.OK);
//	//	try {
//			List<Appointments> appointmentByID= this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates);
//	//		return ResponseEntity.ok(appointmentByID);
////		} catch (Exception e) {
////			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
////		}
////		List<Appoinments> citasPorAfiliado= this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates);
////		if (citasPorAfiliado.isEmpty()) {
////			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
////		}else {
////		
////		return ResponseEntity.ok(citasPorAfiliado);
////		}
//		
//		if (appointmentByID !=null) {
//			
//			return new ResponseEntity<List<Appointments>> (this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates), HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////		
	}
	
	
	@RequestMapping (value ="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int id){
		
		try {
			Appointments appointmentById= this.appoinmentsServiceImpl.getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(appointmentById);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

	
	
	
	
	@RequestMapping (value ="/listadoporfecha/{date}", method = RequestMethod.GET)
	
	public ResponseEntity<?>getByDate (@PathVariable String date)
	
	{
       // try {
        	List<Appointments> appointmentsByDate = this.appoinmentsServiceImpl.findByDateOrderByIdAffiliateAsc(date);
            
            return ResponseEntity.ok(appointmentsByDate);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		
        
    }
		
	
	


}
