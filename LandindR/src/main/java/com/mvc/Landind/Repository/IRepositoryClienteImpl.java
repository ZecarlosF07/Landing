package com.mvc.Landind.Repository;

import com.mvc.Landind.Model.Cliente;
import com.mvc.Landind.Patters.conexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IRepositoryClienteImpl implements IRepositoryCliente{

    @Override
    public List<Cliente> Listar() {
        String SQL = "select nID, bEstado, cNombre, cApellido, cEmail, dtFechaRegistro from cliente where bestado = 1";

        List<Cliente> clientes = new ArrayList<Cliente>();

        try(
                Connection con = conexionBD.getConexion();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
        ){

            while (rs.next()){

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setEstado(rs.getBoolean(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setCreateAt(rs.getString(6));

                clientes.add(cliente);

            }

        }catch (SQLException e){
            e.printStackTrace();

        }

        return clientes;
    }

    @Override
    public Cliente ListarPorId(long id) {

        String SQL = "select nID, bEstado, cNombre, cApellido, cEmail, dtFechaRegistro from cliente where bestado = 1 and nID = ?";
        Cliente cliente = null;

        try(
                Connection con = conexionBD.getConexion();
                PreparedStatement pstmt = con.prepareStatement(SQL);
        ){

            pstmt.setLong(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){

                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setEstado(rs.getBoolean(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setCreateAt(rs.getString(6));


            }

        }catch (SQLException e){

            e.printStackTrace();

        }

        return cliente;

    }

    @Override
    public int Crear(Cliente objeto) {

        String SQL = "insert into cliente(cNombre, cApellido, cEmail) values(?,?,?)";
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
    public int Modificar(Cliente objeto) {

        String SQL = "update cliente set cNombre = ?, cApellido = ?, cEmail = ? where nID = ? and bestado = 1";

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

        String SQL = "update cliente set bEstado = 0 where nID = ? and bestado = 1";
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
