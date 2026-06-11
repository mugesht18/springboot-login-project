package com.kodnest.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.learn.entity.MyEntity;

public interface MyRepository extends JpaRepository<MyEntity, Integer> {
	
	MyEntity findByEmailAndPassword(String email, String password);

}
