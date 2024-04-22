package com.mvc.Landind.Controller;

import com.mvc.Landind.Model.CategoriaProducto;
import com.mvc.Landind.Services.IServiceCategoriaProducto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apicategorias")
public class CatProductosRestController {

    @Autowired
    private IServiceCategoriaProducto serviceCategoriaProducto;

    @Operation(summary = "Obtiene todos los productos")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Obtener todos los productos disponibles",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaProducto.class))}),
            @ApiResponse(responseCode = "404", description = "No existe información",content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/listar")
    public List<CategoriaProducto> Listar(){

        return serviceCategoriaProducto.Listar();

    }

    @Operation(summary = "Obtener el producto por el id")
    @GetMapping("/listarporid/{id}")
    public CategoriaProducto Listarporid(@PathVariable long id){

        return serviceCategoriaProducto.ListarPorId(id);

    }

    @PostMapping("/crear")
    public int crear(@RequestBody CategoriaProducto CategoriaProducto){

        return serviceCategoriaProducto.Crear(CategoriaProducto);

    }

    @PutMapping("/modificar/{id}")
    public int modificar(@RequestBody CategoriaProducto CategoriaProducto, @PathVariable Long id){

        CategoriaProducto categoriaPeli = serviceCategoriaProducto.ListarPorId(id);
        categoriaPeli.setNombre(CategoriaProducto.getNombre());
        categoriaPeli.setTipo(CategoriaProducto.getTipo());

        return serviceCategoriaProducto.Modificar(categoriaPeli);

    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable Long id){

        return serviceCategoriaProducto.Eliminar(id);

    }

}
