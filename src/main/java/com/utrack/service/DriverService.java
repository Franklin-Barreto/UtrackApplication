package com.utrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utrack.entity.Driver;
import com.utrack.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;

	public Driver findById(Integer id) {
		System.out.println("TESTE");
		return driverRepository.findOne(id);
	}
}
