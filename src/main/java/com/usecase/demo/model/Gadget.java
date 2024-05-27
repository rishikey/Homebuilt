package com.usecase.demo.model;
@entity
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

    public String make;
    public String model;
    public int quantity;
    public double price;

}
