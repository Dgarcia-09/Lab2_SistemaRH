package com.diegogarcia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegogarcia.system.model.Empleados;

public interface EmpleadoRepository extends JpaRepository<Empleados, Integer>{

}
