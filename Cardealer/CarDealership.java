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
public class CarDealership {

    private Car[] cars = new Car[5];
    private final int CARSLENGTH = 5;
    private static int count = 0;

    public CarDealership() {
    }

    public void testDrive(Car c) {
        if (count == 0) {
            System.out.println("There is no car in dealership!");
        } else {
            if (isTestable(c)) {
                c.test();
                c.toString();
            }
        }
    }
    
    public void sellCar(Car c, int i){
        if (count == 0){
            System.out.println("You do not have cars, you can sell nothing!");
        } else {
            count--;
            cars[i]=null;
        }
        
    }

    public void insertNewCar(Car c, int i) {
        if (count == CARSLENGTH) {
            System.out.println("The dealership is full! You can not store more cars!");
        } else {
            cars[i] = c;
            count++;
            System.out.println("Stored succesfully: " + c.toString());
        }
    }

    private boolean isTestable(Car c) {
        return c.getId() % 2 == 0;
    }

    public int getValueOfCars() {
        if (count != 0) {
            int totalValue = 0;
            for (int i = 0; i < count; i++) {
                totalValue += cars[i].getPrice();
            }
            return totalValue;
        } else {
            return 0;
        }
    }

    public int getCountOfCars() {
        return count;
    }

}
