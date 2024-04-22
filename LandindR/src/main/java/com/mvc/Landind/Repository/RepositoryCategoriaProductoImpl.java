package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.CategoriaProducto;
import com.mvc.Landind.Patters.conexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCategoriaProductoImpl implements IRepositoryCategoriaProducto {
    @Override
    public List<CategoriaProducto> Listar() {
        String SQL = "select nID, bEstado, cNombre, nTipo, dtFechaRegistro, cUsuarioRegistro from CategoriaProducto where bestado = 1";

        List<CategoriaProducto> CategoriaProductos = new ArrayList<CategoriaProducto>();

        try(
                Connection con = conexionBD.getConexion();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ){

            while (rs.next()){

                CategoriaProducto CategoriaProducto = new CategoriaProducto();
                CategoriaProducto.setId(rs.getInt(1));
                CategoriaProducto.setEstado(rs.getBoolean(2));
                CategoriaProducto.setNombre(rs.getString(3));
                CategoriaProducto.setTipo(rs.getInt(4));
                CategoriaProductos.add(CategoriaProducto);

            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return CategoriaProductos;
    }

    @Override
    public CategoriaProducto ListarPorId(long id) {

        String SQL = "select nID, bEstado, cNombre, nTipo, dtFechaRegistro, cUsuarioRegistro from CategoriaProducto where bestado = 1 and nID = ?";
        CategoriaProducto CategoriaProducto = null;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setLong(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){

                CategoriaProducto = new CategoriaProducto();
                CategoriaProducto.setId(rs.getInt(1));
                CategoriaProducto.setEstado(rs.getBoolean(2));
                CategoriaProducto.setNombre(rs.getString(3));
                CategoriaProducto.setTipo(rs.getInt(4));

            }

        }catch (SQLException e){

            e.printStackTrace();

        }

        return CategoriaProducto;

    }

    @Override
    public int Crear(CategoriaProducto objeto) {

        String SQL = "insert into CategoriaProducto(cNombre, nTipo, cUsuarioRegistro) values(?,?,?)";
        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setInt(2,objeto.getTipo());

            resultado = pstmt.executeUpdate();

        }
        catch (SQLException e){

            e.printStackTrace();
            resultado = -1;

        }

        return resultado;

    }

    @Override
    public int Modificar(CategoriaProducto objeto) {

        String SQL = "update CategoriaProducto set cNombre = ?, nTipo = ?, dtFechaRegistro = ?, cUsuarioRegistro = ? where nID = ? and bestado = 1";
        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setInt(2,objeto.getTipo());

            resultado = pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;

    }

    @Override
    public int Eliminar(long id) {

        String SQL = "update CategoriaProducto set bEstado = 0 where nID = ? and bestado = 1";
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
