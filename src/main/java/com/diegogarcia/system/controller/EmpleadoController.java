package com.diegogarcia.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegogarcia.system.model.Empleados;
import com.diegogarcia.system.services.IEmpleadoService;

@RestController // https://localhost:8081/rh-empleado

@RequestMapping("rh-empleado")


public class EmpleadoController {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);


@Autowired
    private IEmpleadoService iEmpleadoService;

    // http://localhost:8081/rh-empleado/empleados

    @GetMapping("/empleados")

    public List<Empleados> obtenerEmpleado(){
        var empleado2 = iEmpleadoService.listarEmpleados();
        empleado2.forEach((empleado -> logger.info(empleado.toString())));
        return empleado2;

        
    }





}
