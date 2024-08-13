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

import com.diegogarcia.system.exception.ClienteException;
import com.diegogarcia.system.model.Cliente;
import com.diegogarcia.system.services.IClienteService;

@RestController   // https://localhost:8081/rh-cliente

@RequestMapping("rh-cliente")

public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired

    private IClienteService iClienteService;

    // http://localhost:8081/rh-cliente/clientes

    @GetMapping("/clientes")


    public List<Cliente> obtenerCliente(){
        var cliente2 = iClienteService.listarClientes();
        cliente2.forEach((cliente -> logger.info(cliente.toString())));
        return cliente2;

    }


    @PostMapping("/clientesA")

    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        logger.info("Cliente agregado");
        return iClienteService.guardarCliente(cliente);
    }
    


    @GetMapping("/clientesb/{id}")

    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) {
        Cliente cliente = iClienteService.buscarCliente(id);
        if (cliente == null)
            throw new ClienteException("No se encontro el cliente");
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/clientesV/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Integer id, @RequestBody Cliente clienteRecibido) {
        Cliente cliente = iClienteService.buscarCliente(id);
        if (cliente == null)
            throw new ClienteException("El id recibido no existe");

        cliente.setNombreCliente(clienteRecibido.getNombreCliente());
        cliente.setCorreoCliente(clienteRecibido.getCorreoCliente());
        cliente.setDireccionCliente(clienteRecibido.getDireccionCliente());
        cliente.setTipo(clienteRecibido.getTipo());
        iClienteService.guardarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/clientesE/{id}")

    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Integer id) {
        Cliente cliente = iClienteService.buscarCliente(id);
        if(cliente == null)
            throw new ClienteException("El cliente no existe");
        iClienteService.eliminarCliente(cliente);
            
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", true);
        return ResponseEntity.ok(respuesta);

    }

}
