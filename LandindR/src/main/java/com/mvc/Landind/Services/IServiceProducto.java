package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Producto;

import java.util.List;

public interface IServiceProducto {

    int Crear(Producto Producto);

    List<Producto> Listar();

    Producto ListarPorId(long id);

    int Modificar(Producto Producto);

    int Eliminar(long id);

}
