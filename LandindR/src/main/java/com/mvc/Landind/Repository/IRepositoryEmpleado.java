package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.Empleado;

import java.util.List;

public interface IRepositoryEmpleado {

    List<Empleado> Listar();
    Empleado ListarPorId(long id);
    int Crear(Empleado objeto);
    int Modificar(Empleado objeto);
    int Eliminar(long id);

}
