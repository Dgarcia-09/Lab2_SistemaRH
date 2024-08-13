package com.diegogarcia.system.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public Cliente agregarCliente(@RequestBody Cliente cliente){
        logger.info("Cliente agregado");
        return iClienteService.guardarCliente(cliente);
    }

}
