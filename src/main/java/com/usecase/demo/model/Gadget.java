package com.usecase.demo.model;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Gadget {

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;`
    }

    public int getQunatity() {
        return quantity;
    }

    public void setQunatity(int qunatity) {
        this.quantity = qunatity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
    public double price;

}
