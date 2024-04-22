package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.Empleado;
import com.mvc.Landind.Patters.conexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IRepositoryEmpleadoImpl implements IRepositoryEmpleado{

    @Override
    public List<Empleado> Listar() {
        String SQL = "select nID, bEstado, cNombre, cApellido, cEmail, dtFechaRegistro from Empleado where bestado = 1";

        List<Empleado> Empleados = new ArrayList<Empleado>();

        try(
                Connection con = conexionBD.getConexion();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ){

            while (rs.next()){

                Empleado Empleado = new Empleado();
                Empleado.setId(rs.getInt(1));
                Empleado.setEstado(rs.getBoolean(2));
                Empleado.setNombre(rs.getString(3));
                Empleado.setApellido(rs.getString(4));
                Empleado.setEmail(rs.getString(5));
                Empleado.setCreateAt(rs.getString(6));

                Empleados.add(Empleado);

            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return Empleados;
    }

    @Override
    public Empleado ListarPorId(long id) {

        String SQL = "select nID, bEstado, cNombre, cApellido, cEmail, dtFechaRegistro from Empleado where bestado = 1 and nID = ?";
        Empleado Empleado = null;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setLong(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){

                Empleado = new Empleado();
                Empleado.setId(rs.getInt(1));
                Empleado.setEstado(rs.getBoolean(2));
                Empleado.setNombre(rs.getString(3));
                Empleado.setApellido(rs.getString(4));
                Empleado.setEmail(rs.getString(5));
                Empleado.setCreateAt(rs.getString(6));


            }

        }catch (SQLException e){

            e.printStackTrace();

        }

        return Empleado;

    }

    @Override
    public int Crear(Empleado objeto) {

        String SQL = "insert into Empleado(cNombre, cApellido, cEmail) values(?,?,?)";
        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setString(2,objeto.getApellido());
            pstmt.setString(3,objeto.getEmail());

            resultado = pstmt.executeUpdate();

        }
        catch (SQLException e){

            e.printStackTrace();
            resultado = -1;

        }

        return resultado;

    }

    @Override
    public int Modificar(Empleado objeto) {

        String SQL = "update Empleado set cNombre = ?, cApellido = ?, cEmail = ? where nID = ? and bestado = 1";

        int resultado = -1;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setString(1,objeto.getNombre());
            pstmt.setString(2,objeto.getApellido());
            pstmt.setString(3, objeto.getEmail());
            pstmt.setInt(4,objeto.getId());

            resultado = pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;

    }

    @Override
    public int Eliminar(long id) {

        String SQL = "update Empleado set bEstado = 0 where nID = ? and bestado = 1";
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
