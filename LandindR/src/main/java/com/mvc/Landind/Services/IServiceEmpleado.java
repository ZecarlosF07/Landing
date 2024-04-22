package com.mvc.Landind.Services;

import com.mvc.Landind.Model.Empleado;

import java.util.List;

public interface IServiceEmpleado {
    int Crear(Empleado Empleado);
    List<Empleado> Listar();
    Empleado ListarPorId(long id);
    int Modificar(Empleado Empleado);
    int Eliminar(long id);

}
