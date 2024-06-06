package com.usecase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Gadget {

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQunatity() {
        return quantity;
    }

    public void setQunatity(int qunatity) {
        this.quantity = qunatity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
     @Id
    public Integer id;
    public String make;
    public String model;
    public int quantity;
    public int price;

}
