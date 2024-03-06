package com.example.Fitenssobacked.repository;

import com.example.Fitenssobacked.model.FitenssTypeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitenssTypeClassRepository extends JpaRepository<FitenssTypeClass, Long> {

}