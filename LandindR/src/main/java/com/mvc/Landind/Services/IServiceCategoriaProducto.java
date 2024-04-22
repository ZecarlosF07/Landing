package com.mvc.Landind.Services;

import com.mvc.Landind.Model.CategoriaProducto;

import java.util.List;

public interface IServiceCategoriaProducto {
    int Crear(CategoriaProducto categoriaPelicula);
    List<CategoriaProducto> Listar();
    CategoriaProducto ListarPorId(long id);
    int Modificar(CategoriaProducto categoriaPelicula);
    int Eliminar(long id);

}
