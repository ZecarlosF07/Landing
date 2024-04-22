package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Cliente;
import com.mvc.Landind.Repository.IRepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClienteImpl implements IServiceCliente{

    @Autowired
    private IRepositoryCliente repositoryCliente;

    @Override
    public int Crear(Cliente cliente) {
        return repositoryCliente.Crear(cliente);
    }

    @Override
    public List<Cliente> Listar() {
        return repositoryCliente.Listar();
    }

    @Override
    public Cliente ListarPorId(long id) {
        return repositoryCliente.ListarPorId(id);
    }

    @Override
    public int Modificar(Cliente cliente) {
        return repositoryCliente.Modificar(cliente);
    }

    @Override
    public int Eliminar(long id) {
        return repositoryCliente.Eliminar(id);
    }

}
