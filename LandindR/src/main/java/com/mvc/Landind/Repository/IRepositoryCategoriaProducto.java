package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.CategoriaProducto;

import java.util.List;

public interface IRepositoryCategoriaProducto {
    List<CategoriaProducto> Listar();
    CategoriaProducto ListarPorId(long id);
    int Crear(CategoriaProducto objeto);
    int Modificar(CategoriaProducto objeto);
    int Eliminar(long id);

}
