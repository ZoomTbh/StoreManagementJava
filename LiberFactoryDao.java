/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Client;
import model.Product;

/**
 *
 * @author royon
 */
public class LiberFactoryDao {
    private String dbUrl = "jdbc:mysql://localhost:3306/ese_sueno_db_management";
    private String username ="root";
    private String passwd = "";
    private ResultSet rs = null;

    public LiberFactoryDao(){
        
    }

public ArrayList<Product> BindTable() throws SQLException{
     ArrayList<Product>list = new ArrayList<Product>();
     Connection con = DriverManager.getConnection(dbUrl,username,passwd);
     Statement st;
     ResultSet rs;
     try {
            
            
            st = con.createStatement();
            rs= st.executeQuery("select product_id, size_, price,quantity, price_total,image FROM liberfactoryinventory ");
            Product p;
            while(rs.next()){
                p = new Product(
                                rs.getString("product_id"),
                                rs.getString("size_"),
                                rs.getInt("price"),
                                rs.getInt("quantity"),
                                rs.getInt("price_total"),
                                rs.getBytes("image")
                                
                );
            list.add(p);
            }
}catch(SQLException ex) {
            ex.printStackTrace();
}
   return list; 
}


public Product searchByID (Product product){
try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ese_sueno_db_management","root","");
            String sql = "select * from liberfactoryinventory where product_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, product.getProduct_id());
            ResultSet result = pst.executeQuery();
            Product p = new Product();
            boolean flag = false;
            while(result.next()){
                
                p.setSize(result.getString("size_"));
                p.setPrice(result.getInt("price"));
                p.setProduct_id(result.getString("product_id"));
                p.setQuantity(result.getInt("quantity"));
                byte[] img = result.getBytes("image");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                
                flag=true;
               
                //priceTxt.set
            }
            
            con.close();
            if(flag){
                System.out.println("Product ID : "+product.getProduct_id());
                return p;
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
}
}
