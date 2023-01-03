/**
 * 
 */
package com.example.reto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reto.entity.TestLab;

public interface TestRepository extends JpaRepository<TestLab, Integer> {

}