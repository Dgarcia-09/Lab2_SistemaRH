package com.diegogarcia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegogarcia.system.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
