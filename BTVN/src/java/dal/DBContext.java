/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            String user = "tubm";
            String pass = "123";
            String url = "jdbc:sqlserver://TU\\SERVERTRAIDAT:1433;databaseName=view;encrypt=true;trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
