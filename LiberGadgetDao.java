/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Client;

/**
 *
 * @author royon
 */
public class LiberGadgetDao {
    private String dbUrl = "jdbc:mysql://localhost:3306/ese_sueno_db_management";
    private String username ="root";
    private String passwd = "";
    private ResultSet rs = null;
    
 public LiberGadgetDao(){
     
 }
 public String registerClient(Client clientLg){
        try{
          
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
           // Create Prepared Statement by ZoomTbh
           String sql ="insert into libergadgetinventory (cmd_id, first_name,last_name,phone_number,service,amount) values(?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
          
           pst.setString(1, clientLg.getFirst_name());
           pst.setString(2, clientLg.getLast_name());
           pst.setString(3, clientLg.getPhone_number());
           pst.setString(4, clientLg.getService());
           pst.setInt(5,clientLg.getAmount() );
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
//                con.close();
                return "Data Saved Successful";
            }else{
//                con.close();
                return "Data Not Saved";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return "Server Error!!";
    }
  public Client searchClient(Client clientLg){
        try{
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "select * from libergadgetinventory where cmd_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, clientLg.getCmd_id());
            ResultSet result = pst.executeQuery();
            Client cl = new Client();
            boolean flag = false;
            while(result.next()){
                cl.setFirst_name(result.getString("first_name"));
                cl.setLast_name(result.getString("last_name"));
                cl.setAmount(result.getInt("amount"));
                cl.setPhone_number(result.getString("phone_number"));
                cl.setCmd_id(result.getInt("cmd_id"));
                flag=true;
            }
            
            con.close();
            if(flag){
                System.out.println("Command ID: "+cl.getCmd_id());
                return cl;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   public String updateClient(Client clientLg){
        try{
            Connection con = DriverManager.getConnection(dbUrl,username,passwd);
           String sql ="update libergadgetinventory set first_name=?,last_name=?, phone_number=?,service=?,amount=? where cmd_id=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, clientLg.getFirst_name());
           pst.setString(2, clientLg.getLast_name());
           pst.setString(3, clientLg.getPhone_number());
           pst.setString(4, clientLg.getService());
           pst.setInt(5,clientLg.getAmount());
           pst.setInt(6, clientLg.getCmd_id());
            
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){

                return "Data update Successful";
            }else{

                return "Data Not updated";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return "Server Error!!";
    }
    public String deleteClient(Client clientLg){
        try{
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "delete from libergadgetinventory where cmd_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, clientLg.getCmd_id());
            int rowAffected= pst.executeUpdate();
            con.close();
           if(rowAffected>0){
               return "Client Deleted";
           }else{
               return "Client not deleted";
           }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Client> allClient(){
        try{
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "select * from libergadgetinventory";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            List<Client> clientList = new ArrayList<>();
            while(result.next()){
                Client clientObj = new Client();
                clientObj.setFirst_name(result.getString("first_name"));
                clientObj.setLast_name(result.getString("last_name"));
                clientObj.setCmd_id(result.getInt("cmd_id"));
                clientObj.setAmount(result.getInt("amount"));
                clientObj.setService(result.getString("service"));
                clientObj.setPhone_number(result.getString("phone_number"));
                clientList.add(clientObj);
            }
            con.close();
            return clientList;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

