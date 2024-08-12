package com.diegogarcia.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegogarcia.system.model.Empleados;
import com.diegogarcia.system.repository.EmpleadoRepository;

@Service

public class EmpleadoService implements IEmpleadoService{

    @Autowired

    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleados> listarEmpleados() {
        return(empleadoRepository.findAll());
    }

    @Override
    public Empleados buscarEmpleado(Integer idEmpleado) {

        Empleados empleados = empleadoRepository.findById(idEmpleado).orElse(null);
        

        return empleados;
    }

    @Override
    public Empleados guardarEmpleado(Empleados empleados) {
        return empleadoRepository.save(empleados);
    }

    @Override
    public void eliminarEmpleado(Empleados empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEmpleado'");
    }


}
