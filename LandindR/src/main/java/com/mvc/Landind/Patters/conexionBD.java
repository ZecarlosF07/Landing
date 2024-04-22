package com.mvc.Landind.Patters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {

    private static String url="jdbc:sqlserver://localhost\\MSSQLSERVER2022;databaseName=BDMovieCity;TrustServerCertificate=true";

    //private static String url="jdbc:sqlserver://localhost\\MSSQLSERVER2022;databaseName=BDMovieCity;authenticationScheme=NTLM;integratedSecurity=true;domain=CMACICA.COM:PE;encrypt=true;TrustServerCertificate=true";
    private static String userName = "sa";
    private static String password = "deepermind";
    private static Connection con;

    public static Connection getConexion() throws SQLException {

        con = DriverManager.getConnection(url,userName, password);

        //con = DriverManager.getConnection(url,"XXXXX","XXXXX");

        return con;
    }

    public static Connection setConection(String url, String userName, String password) throws SQLException {

        //con = DriverManager.getConnection(url,userName, password);

        con = DriverManager.getConnection(url);


        return con;
    }

}
