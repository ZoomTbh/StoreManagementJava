/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.EseSueno;
import model.Client;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.InputStream;
import view.LiberFactory;
import view.LogIn;


/**
 *
 * @author royon
 */
public class EseSuenoDao {
    private String dbUrl = "jdbc:mysql://localhost:3306/ese_sueno_db_management";
    private String username ="root";
    private String passwd = "";
    private ResultSet rs = null;

public EseSuenoDao(){

}







public String registerUserLiberFactory(EseSueno esesuenoObj){
    try {
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
            String sql = "insert into liberfactory (username,password_hash,first_name,last_name,phone_number,gender,company,birthday_) values(?,?,?,?,?,?,?,?)";
            java.util.Date date=new java.util.Date();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,esesuenoObj.getUsername());
            pst.setString(2,esesuenoObj.getPassword_hash());
            pst.setString(3,esesuenoObj.getFirst_name());
            pst.setString(4,esesuenoObj.getLast_name());
            pst.setString(5,esesuenoObj.getPhone_number());
            pst.setString(6,esesuenoObj.getGender());
            pst.setString(7,esesuenoObj.getCompany());
            pst.setString(8,esesuenoObj.getBirthdate());
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
                return("Data Saved Successfully");
            }else{
                return("Data Not Saved");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
  
 return("Server Error");   
    
    
    
}

public String registerUserLiberGadget(EseSueno esesuenoObj){
    try {
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
            String sql = "insert into libergadget (username,password_hash,first_name,last_name,phone_number,gender,company) values(?,?,?,?,?,?,?)";
            java.util.Date date=new java.util.Date();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,esesuenoObj.getUsername());
            pst.setString(2,esesuenoObj.getPassword_hash());
            pst.setString(3,esesuenoObj.getFirst_name());
            pst.setString(4,esesuenoObj.getLast_name());
            pst.setString(5,esesuenoObj.getPhone_number());
            pst.setString(6,esesuenoObj.getGender());
            pst.setString(7,esesuenoObj.getCompany());
            //pst.setDate(7,esesuenoObj.getBirthdate());
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
                return("Data Saved Successfully");
            }else{
                return("Data Not Saved");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
  
 return("Server Error");   
    
    
    
}

public String LogInLiberFactory(EseSueno esesuenoObj){
    try {
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
            
            String sql = "SELECT COUNT(*) FROM liberfactory WHERE username=? AND password_hash=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, esesuenoObj.getUsername());
            pst.setString(2, esesuenoObj.getPassword_hash());
                    // execute statemet
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                   
                    
            int count = rs.getInt(1);
                    // close connection
                    con.close();
                    if (count == 1) {
                        
                        JOptionPane.showMessageDialog(null, "WELCOME TO YOUR ACCOUNT ");
            LiberFactory LogInFrame = new LiberFactory();
            LogInFrame.setVisible(true);
            LogInFrame.pack();
            LogInFrame.setLocation(null);
          
                    }     else {
                        JOptionPane.showMessageDialog(null, "Incorrect ID or password");
                        
                    }
                    
    }catch(SQLException ex) {
            ex.printStackTrace();
    }
        return null;
}

 public String LogInLiberGadget(EseSueno esesuenoObj){
    try {
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
            
            String sql = "SELECT COUNT(*) FROM liberfactory WHERE username=? AND password_hash=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, esesuenoObj.getUsername());
            pst.setString(2, esesuenoObj.getPassword_hash());
                    // execute statemet
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                   
                    
            int count = rs.getInt(1);
                    // close connection
                    con.close();
                    if (count == 1) {
                        
                        JOptionPane.showMessageDialog(null, "WELCOME TO YOUR ACCOUNT ");
            LiberFactory LogInFrame = new LiberFactory();
            LogInFrame.setVisible(true);
            LogInFrame.pack();
            LogInFrame.setLocation(null);
          
                    }     else {
                        JOptionPane.showMessageDialog(null, "Incorrect ID or password");
                        
                    }
                    
    }catch(SQLException ex) {
            ex.printStackTrace();
    }
        return null;
}    
        
    

public ResultSet retrieveProduct(EseSueno esesuenoObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
            String sql = "select image from liberfactoryinventory order by product_id";
            PreparedStatement pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
}

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param product_id
     * @return
     */
    

}