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
public class Mercedes extends Car {

    public Mercedes(String licensePlate, int horsePower, String color, double mileage, double consumption, int price) {
        this.id = super.generateId();
        this.licensePlate = licensePlate;
        this.horsePower = horsePower;
        this.color = color;
        this.mileage = mileage;
        this.consumption = consumption;
        this.price = price;
    }

    @Override
    public void test() {
        this.consumption += 0.04;
    }

    @Override
    public String toString() {
        return "Mercedes " + " id= " + this.id + " license plate= " + this.licensePlate;
    }
}
