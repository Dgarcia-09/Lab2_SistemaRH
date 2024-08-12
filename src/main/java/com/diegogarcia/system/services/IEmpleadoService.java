package com.diegogarcia.system.services;

import java.util.List;

import com.diegogarcia.system.model.Empleados;

public interface IEmpleadoService {

    public List<Empleados> listarEmpleados();

    public Empleados buscarEmpleado (Integer idEmpleado);

    public Empleados guardarEmpleado (Empleados empleados);

    public void eliminarEmpleado (Empleados empleados);

}
