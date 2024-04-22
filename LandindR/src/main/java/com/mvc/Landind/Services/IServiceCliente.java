package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Cliente;

import java.util.List;

public interface IServiceCliente {
    int Crear(Cliente cliente);
    List<Cliente> Listar();
    Cliente ListarPorId(long id);
    int Modificar(Cliente cliente);
    int Eliminar(long id);

}
