package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Property;
import com.app.pojos.PropertyStatus;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
	List <Property>findByPropertyStatus(PropertyStatus status);
}
