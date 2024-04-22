package com.mvc.Landind.Controller;

import com.mvc.Landind.Model.Empleado;
import com.mvc.Landind.Services.IServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEmpleados")
public class EmpleadoRestController {


    @Autowired
    private IServiceEmpleado serviceEmpleado;

    @GetMapping("/listar")
    public List<Empleado> Listar(){

        return serviceEmpleado.Listar();

    }

    @GetMapping("/listarporid/{id}")
    public Empleado Listarporid(@PathVariable long id){

        return serviceEmpleado.ListarPorId(id);

    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public int crear(@RequestBody Empleado Empleado){

        return serviceEmpleado.Crear(Empleado);

    }

    @PutMapping("/modificar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public int modificar(@RequestBody Empleado Empleado, @PathVariable Long id){

        Empleado Empleado1 = serviceEmpleado.ListarPorId(id);
        Empleado1.setNombre(Empleado.getNombre());
        Empleado1.setApellido(Empleado.getApellido());
        Empleado1.setEmail(Empleado.getEmail());

        return serviceEmpleado.Modificar(Empleado1);

    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable Long id){

        return serviceEmpleado.Eliminar(id);

    }


}
