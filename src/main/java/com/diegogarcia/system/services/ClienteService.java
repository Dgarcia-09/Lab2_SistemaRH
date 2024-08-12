package com.diegogarcia.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegogarcia.system.model.Cliente;
import com.diegogarcia.system.repository.ClienteRepository;

@Service

public class ClienteService implements IClienteService {


    @Autowired

    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
    return(clienteRepository.findAll());
    }

    @Override
    public Cliente buscarCliente(Integer idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        return cliente;
    
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
    clienteRepository.delete(cliente);
    }
}
