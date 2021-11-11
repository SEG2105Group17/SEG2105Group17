package com.example.databases;

public class Product {
    private int _id;
    private String _productname;
    private double _price;

    public Product(){
    }
    public Product(int id, String productName, double price){
        _id = id;
        _productname = productName;
        _price = price;
    }
    public Product(String productName, double price){
        _productname = productName;
        _price = price;
    }

    public void setID(int id){_id = id;}
    public int getID(){return _id;}
    public void setProductName(String productname){_productname = productname;}
    public String getProductName(){return _productname;}
    public void setPrice(double price){_price = price;}
    public double getPrice(){return _price;}

}
