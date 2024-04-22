package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.Producto;
import com.mvc.Landind.Patters.conexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryProductoImpl implements IRepositoryProducto {

    @Override
    public List<Producto> Listar() {
        //String SQL = "select nID,bEstado,cNombre,cDescripcion,cDirector,cImagen,nDuracion,nIDTrailer,nIDCategoria,dtFechaRegistro,cUsuarioRegistro,dtFechaEliminacion,cUsuarioEliminacion from Producto where bestado = 1";

        /*
        String SQL = "select b.nID,b.bEstado,b.cNombre,b.cDescripcion,b.cDirector,b.cImagen,b.nDuracion, c.cNombre,a.cNombre,"+
                "\nb.dtFechaRegistro,b.cUsuarioRegistro, b.dtFechaEliminacion,b.cUsuarioEliminacion"+
                "\nfrom CategoriaProducto a join Producto b on a.nid = b.nIDCategoria"+
                "\njoin Trailer c on b.nIDTrailer = c.nID"+
                "\nwhere a.bestado = 1 and b.bEstado = 1 and c.bEstado = 1;";
        */

        String SQL = "{call PA_LISTARProductoS}";

        List<Producto> Productos = new ArrayList<Producto>();

        try(
                Connection con = conexionBD.getConexion();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ){

            while (rs.next()){

                Producto Producto = new Producto();
                Producto.setId(rs.getInt(1));
                Producto.setEstado(rs.getBoolean(2));
                Producto.setNombre(rs.getString(3));
                Producto.setDescripcion(rs.getString(4));
              Producto.setCategoriaProducto(rs.getString(5));

                Productos.add(Producto);

            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return Productos;
    }

    @Override
    public Producto ListarPorId(long id) {

        String SQL = "select nID,bEstado,cNombre,cDescripcion,cDirector,cImagen,nDuracion,nIDTrailer,nIDCategoria,dtFechaRegistro,cUsuarioRegistro,dtFechaEliminacion,cUsuarioEliminacion from Producto where bestado = 1 and nID = ?";
        Producto Producto = null;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setLong(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){

                Producto = new Producto();

                Producto.setId(rs.getInt(1));
                Producto.setEstado(rs.getBoolean(2));
                Producto.setNombre(rs.getString(3));
                Producto.setDescripcion(rs.getString(4));
                Producto.setCategoriaProducto(rs.getString(5));

            }

        }catch (SQLException e){

            e.printStackTrace();

        }

        return Producto;

    }

    @Override
    public int Crear(Producto objeto) {

        /*String SQL = "insert into Producto(cNombre,cDescripcion,cDirector,cImagen,nDuracion,nIDTrailer,nIDCategoria,cUsuarioRegistro) " +
                      "\nvalues(?,?,?,?,?,?,?,?)";
                      */

        String SQL = "{call PA_INSERTARProducto(?,?,?,?,?,?,?,?)}";

        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setString(2,objeto.getDescripcion());
            pstmt.setInt(3,Integer.parseInt(objeto.getCategoriaProducto()));

            resultado = pstmt.executeUpdate();

        }
        catch (SQLException e){

            e.printStackTrace();
            resultado = -1;

        }

        return resultado;

    }

    @Override
    public int Modificar(Producto objeto) {

        String SQL = "update Producto\n" +
                "set cNombre = ?,\n" +
                "    cDescripcion=?,\n" +
                "\tnIDCategoria=?,\n" +
                "where nID = ? and bestado = 1";
        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setString(2,objeto.getDescripcion());
            pstmt.setInt(3,Integer.parseInt(objeto.getCategoriaProducto()));

            resultado = pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;

    }

    @Override
    public int Eliminar(long id) {

        String SQL = "update Producto set bEstado = 0 where nID = ? and bestado = 1";
        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setLong(1,id);

            resultado = pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;

    }

}
