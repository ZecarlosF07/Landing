package com.mvc.Landind.Controller;

import com.mvc.Landind.Model.CategoriaProducto;
import com.mvc.Landind.Services.ServiceCategoriaProductoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaProductoController {

    @Autowired
    private ServiceCategoriaProductoImpl serviceCategoriaProducto;
    @GetMapping("/listado")
    public String Listar(Model model){
        List<CategoriaProducto> categorias = new ArrayList<CategoriaProducto>();
        categorias = serviceCategoriaProducto.Listar();

        model.addAttribute("listado", categorias);
        model.addAttribute("categoria", "Lista de Categorias");

        return "categorias-pelicula";
    }

}
