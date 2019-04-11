/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oophw1030cardealer;


/**
 *
 * @author Péter
 */
public abstract class Car {

    protected int id;
    protected String licensePlate;
    protected int horsePower;
    protected String color;
    protected double mileage;
    protected double consumption;
    protected int price;
    
    protected abstract void test();
    
    protected int generateId() {
        int generatedId;
        generatedId = (int) (Math.random() * 90000 + 10000);
        return generatedId;
    }

    @Override
    public abstract String toString();

    protected void setMileage(double mileage) {
        this.mileage = mileage;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    protected void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected int getId() {
        return id;
    }

    protected double getMileage() {
        return mileage;
    }

    protected double getConsumption() {
        return consumption;
    }

    protected int getHorsePower() {
        return horsePower;
    }

    protected String getLicensePlate() {
        return licensePlate;
    }

    protected String getColor() {
        return color;
    }

    protected int getPrice() {
        return price;
    }

}
