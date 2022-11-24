package business;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fava_
 */
public class ConnectionDB {
    
    private static ConnectionDB c;
    private Connection connect;

    private ConnectionDB(Connection connect) {
    this.connect = connect;
    }
    
    public static ConnectionDB getInstance(){
    
        if(c == null){
            c = new ConnectionDB(connectionDB());
        }
        
        return c;
    }
    
    
    private static Connection connectionDB(){
    
        String url = "jdbc:sqlserver://DESKTOP-895E554:1433;databaseName=Netflix_DB;user=server;password=server;TrustServerCertificate=True;";
        Connection con;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conectados");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Connection getConnection(){
        return connect;
    }
}
