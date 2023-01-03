/**
 * 
 */
package com.example.reto.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;


/**
 * @author Lenovo
 *Interface que contiene el CRUD con Spring JPA para la tabla de citas
 */
public interface AppoinmentsRepository extends JpaRepository<Appointments, Integer> {
	List<Appointments> findByIdAffiliate(Affiliates idAffiliate);
    List<Appointments> findByDateOrderByIdAffiliateAsc(LocalDate date);
    

}