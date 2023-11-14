/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author royon
 */
public class Client {
        private int cmd_id;
        private String first_name;
        private String last_name;
        private String service;
        private String phone_number;
        private int amount;
  

public Client(){
}

    public Client(int cmd_id, String first_name, String last_name, String service, String phone_number, int amount) {
        this.cmd_id = cmd_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.service = service;
        this.phone_number = phone_number;
        this.amount = amount;
    }

    public int getCmd_id() {
        return cmd_id;
    }

    public void setCmd_id(int cmd_id) {
        this.cmd_id = cmd_id;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    

}