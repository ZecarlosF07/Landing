package com.mvc.Landind.Controller;

import com.mvc.Landind.Model.Producto;
import com.mvc.Landind.Services.IServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Productos")
public class ProductoController {
    @Autowired
    private IServiceProducto serviceProducto;

    @GetMapping("/listar")
   public String Listar(Model model){

        model.addAttribute("Nombre","Listado de Productos");
        model.addAttribute("Productos",serviceProducto.Listar());

       return "listarProductos";
   }

    @PostMapping("/crear")
    public String Crear(Model model){

        model.addAttribute("Nombre","Crear producto");
        //model.addAttribute("Productos",serviceProducto.Listar());

        return "crearProducto";
    }

    @GetMapping("/listarporid/{id}")
    public Producto Listarporid(@PathVariable long id){

        return serviceProducto.ListarPorId(id);

    }


    @PutMapping("/modificar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public int modificar(@RequestBody Producto Producto, @PathVariable Long id){

        Producto Producto1 = serviceProducto.ListarPorId(id);
        Producto1.setNombre(Producto.getNombre());
        Producto1.setDescripcion(Producto.getDescripcion());
        Producto1.setCategoriaProducto(Producto.getCategoriaProducto());

        return serviceProducto.Modificar(Producto1);

    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable Long id){

        return serviceProducto.Eliminar(id);

    }
}
