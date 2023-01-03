/**
 * 
 */
package com.example.reto.service;

import java.util.List;

import com.example.reto.entity.TestLab;

public interface TestService {
	
	List<TestLab> getListTest();
	
	TestLab saveTest(TestLab test);
	
	TestLab updateTest (TestLab test);
	
	void deleteTest (int id);
	
	TestLab getById (int id);
}