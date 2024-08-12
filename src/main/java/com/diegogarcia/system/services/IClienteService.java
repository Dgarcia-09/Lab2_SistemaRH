package com.diegogarcia.system.services;

import java.util.List;

import com.diegogarcia.system.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente buscarCliente(Integer idCliente);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);
}
