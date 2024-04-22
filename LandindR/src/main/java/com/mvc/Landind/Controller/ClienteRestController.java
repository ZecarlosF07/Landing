package com.mvc.Landind.Controller;

import com.mvc.Landind.Model.Cliente;
import com.mvc.Landind.Services.IServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiclientes")
public class ClienteRestController {


    @Autowired
    private IServiceCliente serviceCliente;

    @GetMapping("/listar")
    public List<Cliente> Listar(){

        return serviceCliente.Listar();

    }

    @GetMapping("/listarporid/{id}")
    public Cliente Listarporid(@PathVariable long id){

        return serviceCliente.ListarPorId(id);

    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public int crear(@RequestBody Cliente cliente){

        return serviceCliente.Crear(cliente);

    }

    @PutMapping("/modificar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public int modificar(@RequestBody Cliente cliente, @PathVariable Long id){

        Cliente cliente1 = serviceCliente.ListarPorId(id);
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());
        cliente1.setEmail(cliente.getEmail());

        return serviceCliente.Modificar(cliente1);

    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable Long id){

        return serviceCliente.Eliminar(id);

    }


}
