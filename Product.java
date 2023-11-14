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
public class Product {
    private String product_id;
    private String size;
    private int price;
    private int quantity;
    private int price_total;
     private byte[] image;
    
    
    
    
   public Product(){
       
   }

    public Product(String product_id, String size, int price, int quantity, int price_total, byte[] image) {
        this.product_id = product_id;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.price_total = price_total;
        this.image = image;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice_total() {
        return price_total;
    }

    public void setPrice_total(int price_total) {
        this.price_total = price_total;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

   

    

   
   

    

   
   
}
