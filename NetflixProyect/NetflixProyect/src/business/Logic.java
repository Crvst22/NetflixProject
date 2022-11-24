package business;


import domain.Cuenta;
import domain.Planes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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


public class Logic {
    
    public Logic() {
    }
    
    
    public static void addCuenta(Cuenta c){
        Statement stmt;
        
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            stmt.executeUpdate("Insert INTO Cuenta (codigoPlan,nombre,apellido,correo) Values("+c.getPlanCode()+",'"+c.getName()+"','"+c.getLastName()+"','"+c.getEmail()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<Planes> getPlan(){
        Statement stmt;
        Planes p;
        ArrayList<Planes> plans = new ArrayList<>();
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM planes");
            while(rs.next()){
                p = new Planes(Integer.parseInt(rs.getString("codigo")),rs.getString("nombre"),Integer.parseInt(rs.getString("precio")),Integer.parseInt(rs.getString("cantidadUsuarios")));
                System.out.println(p.toString());
                plans.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plans;
    }
    
     public static ArrayList<Cuenta> getCuenta(){
        Statement stmt;
        Cuenta c;
        ArrayList<Cuenta> acounts = new ArrayList<>();
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cuenta");
            while(rs.next()){
                c = new Cuenta(Integer.parseInt(rs.getString("codigoCuenta")),Integer.parseInt(rs.getString("codigoPlan")),rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo"));
               
                acounts.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return acounts;
    }
     
     public static ArrayList<Cuenta> searchCuenta(int code){
     
     Statement stmt;
       Cuenta c;
        ArrayList<Cuenta> acounts = new ArrayList<>();
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cuenta c where c.codigoCuenta = "+code);
            while(rs.next()){
                c = new Cuenta(rs.getInt("codigoCuenta"),rs.getInt("codigoPlan"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo"));
               
                acounts.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return acounts;
     }
     
    public static void deleteCuenta(int code){
        Statement stmt;
        
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            stmt.executeUpdate("Delete cuenta from cuenta c where c.codigoCuenta = "+code);
            System.out.println("Cuenta eliminada");
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public static void UpdateCuenta(Cuenta c){
        Statement stmt;
        
        try {
            stmt = ConnectionDB.getInstance().getConnection().createStatement();
            stmt.executeUpdate("update cuenta set codigoPlan= "+c.getPlanCode()+", nombre = '"+c.getName()+"', apellido= '"+c.getLastName()+"' where codigoCuenta ="+c.getCode());
            System.out.println("Cuenta modificada");
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
