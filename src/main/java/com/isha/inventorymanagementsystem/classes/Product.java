package com.isha.inventorymanagementsystem.classes;


public class Product {
    private Integer id;
    private String name;
    private Integer quantity;
    private String description;

    public Product(Integer id, String name, Integer quantity, String description)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public Integer getId() { return id; }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }

    public Integer getQuantity() { return quantity; }


}
