package com.restauranteapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.restauranteapp.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

}
