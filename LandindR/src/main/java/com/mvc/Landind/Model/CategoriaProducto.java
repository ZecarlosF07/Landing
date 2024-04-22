package com.mvc.Landind.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProducto {
    private int Id;
    private boolean Estado;
    private String Nombre;
    private int Tipo;
    private Date FechaRegistro;
}
