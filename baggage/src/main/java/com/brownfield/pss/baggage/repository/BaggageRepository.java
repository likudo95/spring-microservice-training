package com.brownfield.pss.baggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brownfield.pss.baggage.entity.Baggage;

public interface BaggageRepository extends JpaRepository<Baggage, Long>{

}
