/**
 * 
 */
package com.example.reto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.TestLab;
import com.example.reto.repository.TestRepository;
import com.example.reto.service.TestService;


@Service
public class TestServiceImpl implements TestService {
	

	@Autowired
	private TestRepository testRepository;
	
	@Override
	public List<TestLab> getListTest() {
		
		List <TestLab> testDataSource = StreamSupport.stream(
				this.testRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return testDataSource;
	}

	@Override
	public TestLab saveTest(TestLab test) {
		return this.testRepository.save(test);
	}

	@Override
	public TestLab updateTest(TestLab test) {
		
		return this.testRepository.save(test);
	}

	@Override
	public void deleteTest(int id) {
		this.testRepository.deleteById(id);
		
	}

	
	@Override
	public TestLab getById(int id) {
		
		return this.testRepository.findById(id).get();
				
	
	}



}