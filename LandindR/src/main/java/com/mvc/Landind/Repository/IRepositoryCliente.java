package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.Cliente;

import java.util.List;

public interface IRepositoryCliente {

    List<Cliente> Listar();
    Cliente ListarPorId(long id);
    int Crear(Cliente objeto);
    int Modificar(Cliente objeto);
    int Eliminar(long id);

}
