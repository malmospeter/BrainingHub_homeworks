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
public class Main {

    public static void main(String[] args) {

        CarDealership dealer = new CarDealership();

        Hummer h1 = new Hummer("AAA-123", 215, "red", 23600, 9.8, 15000);
        Hummer h2 = new Hummer("ZZZ-321", 255, "black", 55000, 11.5, 13500);
        Mercedes m1 = new Mercedes("MBZ-456", 260, "grey", 55700, 8.2, 22500);
        Mercedes m2 = new Mercedes("MBZ-789", 507, "yellow", 33500, 13.5, 35000);
        BMW b1 = new BMW("BMW-999", 355, "blue", 33250, 6.7, 100000);
        BMW b2 = new BMW("BMW-111", 305, "red", 33000, 6.5, 105000);

        dealer.insertNewCar(h1, 0);
        dealer.insertNewCar(m1, 1);
        dealer.insertNewCar(b1, 2);
        dealer.insertNewCar(h2, 3);
        dealer.insertNewCar(m2, 4);
        dealer.insertNewCar(b2, 4);
        dealer.sellCar(h1, 0);
        dealer.insertNewCar(b2, 0);
        
        System.out.println();

        dealer.testDrive(b1);
        dealer.testDrive(m1);

        System.out.println("Car id: " + b1.getId() + " Mileage after first testdrive: " + b1.getMileage());
        System.out.println("Car id: " + m1.getId() + " Consumption after testdrive: " + m1.getConsumption());
        
        System.out.println();

        dealer.testDrive(b1);
        dealer.testDrive(m1);

        System.out.println("Car id: " + b1.getId() + " Mileage after second testdrive: " + b1.getMileage());
        System.out.println("Car id: " + m1.getId() + " Consumption after second testdrive: " + m1.getConsumption());

        System.out.println();

        System.out.println("Number of stored cars: " + dealer.getCountOfCars());
        System.out.println("Value of stored cars: " + dealer.getValueOfCars());

//        System.out.println(h1.toString());
//        System.out.println(m1.toString());
//        System.out.println(b1.toString());
//        
//        m1.setLicensePlate("xxx-333");
//        b1.setLicensePlate("yyy-333");
//        
//        System.out.println(m1.toString());
//        System.out.println(b1.toString());
//                
//        System.out.println(m1.getConsumption());
//        m1.test();
//        System.out.println(m1.getConsumption());
//        m1.test();
//        System.out.println(m1.getConsumption());
//        m1.test();
//        System.out.println(m1.getConsumption());
//        m1.test();
//        System.out.println(m1.getConsumption());
//        System.out.println(b1.getMileage());
//        b1.test();
//        System.out.println(b1.getMileage());
//        b1.test();
//        System.out.println(b1.getMileage());
//        b1.test();
//        System.out.println(b1.getMileage());
//        b1.test();
//        System.out.println(b1.getMileage());
//        b1.test();
    }
}
