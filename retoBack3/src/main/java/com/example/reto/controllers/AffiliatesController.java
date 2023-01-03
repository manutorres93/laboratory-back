/**
 * 
 */
package com.example.reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.reto.service.AffiliatesService;


@RestController
@RequestMapping ("/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesServiceImlp;
	
	
	@GetMapping
	public ResponseEntity<?> getAllAffiliates() {
		
			List<Affiliates> affiliatesGet = this.affiliatesServiceImlp.getListAffiliates();
			
			if (affiliatesGet.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.ok(affiliatesGet);}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> saveAffiliate(@RequestBody Affiliates affiliates) {
		
		try {
			Affiliates savedAffiliate= this.affiliatesServiceImlp.saveAffiliate(affiliates);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedAffiliate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	@PutMapping
	public ResponseEntity<?> updateAffiliate(@RequestBody Affiliates affiliates){
		
		try {
			Affiliates updatedAffiliate= this.affiliatesServiceImlp.updateAffiliate(affiliates);
			return ResponseEntity.status(HttpStatus.CREATED).body(updatedAffiliate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		}
	
	//@DeleteMapping
	@RequestMapping (value ="{idAffiliate}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAffiliate(@PathVariable int idAffiliate){
		
		try {
			this.affiliatesServiceImlp.deleteAffiliate(idAffiliate);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		}
	
	@RequestMapping (value ="{idAffiliate}", method = RequestMethod.GET)
	public ResponseEntity<?> geyById(@PathVariable int idAffiliate){
	
		
		try {
			Affiliates afiliadoPorId= this.affiliatesServiceImlp.getById(idAffiliate);
			return ResponseEntity.status(HttpStatus.OK).body(afiliadoPorId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

}
