/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.accessibility.AccessibleContext;

/**
 *
 * @author royon
 */

    public class EseSueno {
    private String username;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String password_hash;
    private String gender;
    private String company;
    private String birthdate;
    
    
    
    public EseSueno(){
        
    }

    public EseSueno(String username, String first_name, String last_name, String phone_number, String password_hash, String gender, String company, String birthdate) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.password_hash = password_hash;
        this.gender = gender;
        this.company = company;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    

   

   
    }

    

    
    
    
    
   
    

