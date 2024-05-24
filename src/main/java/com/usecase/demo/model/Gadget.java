package com.usecase.demo.model;
@entity
public class gadget {

    public string getModel() {
        return model;
    }

    public void setModel(string model) {
        this.model = model;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
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
