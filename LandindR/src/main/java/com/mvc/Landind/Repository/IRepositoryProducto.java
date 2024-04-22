package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.CategoriaProducto;
import com.mvc.Landind.Model.Producto;

import java.util.List;

public interface IRepositoryProducto {

    List<Producto> Listar();
    Producto ListarPorId(long id);
    int Crear(Producto objeto);
    int Modificar(Producto objeto);
    int Eliminar(long id);

}
