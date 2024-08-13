package com.diegogarcia.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegogarcia.system.exception.EmpleadoException;
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

    public List<Empleados> obtenerEmpleado() {
        var empleado2 = iEmpleadoService.listarEmpleados();
        empleado2.forEach((empleado -> logger.info(empleado.toString())));
        return empleado2;

    }

    @PostMapping("/empleadosA")

    public Empleados agregarEmpleado(@RequestBody Empleados empleados) {
        logger.info("Empleado agregado");
        return iEmpleadoService.guardarEmpleado(empleados);

    }

    @GetMapping("/empleados/{id}")

    public ResponseEntity<Empleados> buscarEmpleado(@PathVariable Integer id) {
        Empleados empleados = iEmpleadoService.buscarEmpleado(id);
        if (empleados == null)
            throw new EmpleadoException("No se encontro el empleado");
        return ResponseEntity.ok(empleados);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleados> editarEmpleados(@PathVariable Integer id,
            @RequestBody Empleados empleadosRecibido) {
        Empleados empleados = iEmpleadoService.buscarEmpleado(id);
        if (empleados == null)
            throw new EmpleadoException("El id recibido no existe");
        empleados.setDpi(empleadosRecibido.getDpi());
        empleados.setNombreCompleto(empleadosRecibido.getNombreCompleto());
        empleados.setPuesto(empleadosRecibido.getPuesto());
        empleados.setSalario(empleadosRecibido.getSalario());
        iEmpleadoService.guardarEmpleado(empleados);
        return ResponseEntity.ok(empleados);
    }
    

    @DeleteMapping("/empleados/{id}")

    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id) {
        Empleados empleados = iEmpleadoService.buscarEmpleado(id);
        if (empleados == null)
            throw new EmpleadoException("El empleado no existe");
        iEmpleadoService.eliminarEmpleado(empleados);

        //JSON {eliminado = true}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", true);
        return ResponseEntity.ok(respuesta);
    
    }

}



    









