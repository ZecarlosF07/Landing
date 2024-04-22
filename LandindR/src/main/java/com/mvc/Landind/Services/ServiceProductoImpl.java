package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Producto;
import com.mvc.Landind.Repository.IRepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductoImpl implements IServiceProducto{

    @Autowired
    private IRepositoryProducto repositoryProducto;

    @Override
    public int Crear(Producto Producto) {
        return repositoryProducto.Crear(Producto);
    }

    @Override
    public List<Producto> Listar() {
        return repositoryProducto.Listar();
    }

    @Override
    public Producto ListarPorId(long id) {
        return repositoryProducto.ListarPorId(id);
    }

    @Override
    public int Modificar(Producto Producto) {
        return repositoryProducto.Modificar(Producto);
    }

    @Override
    public int Eliminar(long id) {
        return repositoryProducto.Eliminar(id);
    }

}
