package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Empleado;
import com.mvc.Landind.Repository.IRepositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpleadoImpl implements IServiceEmpleado{

    @Autowired
    private IRepositoryEmpleado repositoryEmpleado;

    @Override
    public int Crear(Empleado Empleado) {
        return repositoryEmpleado.Crear(Empleado);
    }

    @Override
    public List<Empleado> Listar() {
        return repositoryEmpleado.Listar();
    }

    @Override
    public Empleado ListarPorId(long id) {
        return repositoryEmpleado.ListarPorId(id);
    }

    @Override
    public int Modificar(Empleado Empleado) {
        return repositoryEmpleado.Modificar(Empleado);
    }

    @Override
    public int Eliminar(long id) {
        return repositoryEmpleado.Eliminar(id);
    }

}
