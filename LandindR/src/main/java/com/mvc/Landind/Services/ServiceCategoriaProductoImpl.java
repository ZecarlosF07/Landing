package com.mvc.Landind.Services;

import com.mvc.Landind.Model.CategoriaProducto;
import com.mvc.Landind.Repository.IRepositoryCategoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoriaProductoImpl implements IServiceCategoriaProducto{
    @Autowired
    private IRepositoryCategoriaProducto repositoryCategoriaProducto;

    public int Crear(CategoriaProducto CategoriaProducto){

        return repositoryCategoriaProducto.Crear(CategoriaProducto);
    }

    public List<CategoriaProducto> Listar(){

        return repositoryCategoriaProducto.Listar();
    }

    public CategoriaProducto ListarPorId(long id){

        return repositoryCategoriaProducto.ListarPorId(id);
    }

    public int Modificar(CategoriaProducto CategoriaProducto){

        return repositoryCategoriaProducto.Modificar(CategoriaProducto);
    }

    public int Eliminar(long id){

        return repositoryCategoriaProducto.Eliminar(id);
    }

}


