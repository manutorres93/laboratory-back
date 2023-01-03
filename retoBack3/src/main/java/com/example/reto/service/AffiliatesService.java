/**
 * 
 */
package com.example.reto.service;

import java.util.List;

import com.example.reto.entity.Affiliates;


public interface AffiliatesService {
	
	List<Affiliates> getListAffiliates();
	
	Affiliates saveAffiliate(Affiliates affiliate);
		
	Affiliates updateAffiliate (Affiliates affiliate);
		
	void deleteAffiliate (int idAffiliate);

	Affiliates getById (int idAffiliate);

}