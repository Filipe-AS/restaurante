package com.restauranteapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.restauranteapp.model.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante, String>{
	

}
