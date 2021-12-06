package com.trindadecarol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trindadecarol.entities.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>  {

	Cambio findByfromAndTo(String from, String to);
}
