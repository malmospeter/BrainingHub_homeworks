/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oophw1018Main;

import oophw1018Community.Community;
import oophw1018House.House;

/**
 *
 * @author Peter
 */
public class main {
    
    public static void spaceBetweenLines(){
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        House h1 = new House(12.5, true, 2);
        House h2 = new House(32.5, false, 3, "Malmos");
        House h3 = new House(100, true, 3, "Boldog Ember");
        House h4 = new House(500, true, 9, "legújabb");
        
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        
        System.out.println("Modifying the parameters of the first house: ");
        h1.sell("Minta");
        h1.setSize((3.5*h1.getSize()));
        h1.setNumberOfWindows(6);
        
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        
        spaceBetweenLines();
        
        System.out.println("First and second house:");
        System.out.println(h1);
        System.out.println(h2);
        
        h2.sell("Kis Géza");
        
        System.out.println("New owner of the second house: " + h2.getOwner());
        System.out.println(h2);
        
        spaceBetweenLines();
        
        System.out.println("This is a community: ");        
        Community community1 = new Community(h1, h2, h3);
        Community community2 = new Community(h2, h2, h2);
        Community community3 = new Community(h4, h4, h2);
        System.out.println(community1.toString());
        
        spaceBetweenLines();
        
        //innen a 77. sorig kapcsolódik a House osztály setConstructionCompany() metódusához
        System.out.println(House.getConstructionCompany());
        House.setConstructionCompany("kutya");
        System.out.println(House.getConstructionCompany());
        System.out.println(h3.getConstructionCompany());
        
        h2.setConstructionCompany("alma"); 
        
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(House.getConstructionCompany());
        System.out.println();
        
        System.out.println("Modifying data: ");
        h2.setSize(123.456);
        h3.setOwner("Új tulaj!");
        community1.setH1(h4);
        community1.setH2(h4);
        community3.setH3(h4);
        
        System.out.println(community1.toString());
        System.out.println();
        System.out.println(community2.toString());
        System.out.println();
        System.out.println(community3.toString());
    }
}
