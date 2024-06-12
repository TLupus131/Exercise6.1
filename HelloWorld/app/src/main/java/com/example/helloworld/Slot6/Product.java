package com.example.helloworld.Slot6;

public class Product {
    private String ProductId;
    private String ProductName;
    private int Quantity;

    public Product() {
    }

    public Product(String productId, String productName, int quantity) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() { return Quantity; }

    public void setQuantity(int quantity) { Quantity = quantity; }
}
