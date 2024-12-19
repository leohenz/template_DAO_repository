package com.example.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco {
    private static final String URL = "jdbc:mysql://wagnerweinert.com.br:3306/info23_LEOGONCALVES";
    private static final String USER = "info23_LEOGONCALVES";
    private static final String PASSWORD = "info23_LEOGONCALVES";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

