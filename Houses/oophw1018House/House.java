/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oophw1018House;

/**
 *
 * @author Peter
 */
public class House {

    private double size;
    private boolean balcony;
    private int numberOfWindows;
    private String owner;
    public static String constructionCompany = "Hos Kft.";

    public House(double size, boolean balcony, int numberOfWindows) {
        this.size = size;
        this.balcony = balcony;
        this.numberOfWindows = numberOfWindows;
    }

    public House(double size, boolean balcony, int numberOfWindows, String owner) {
        this.size = size;
        this.balcony = balcony;
        this.numberOfWindows = numberOfWindows;
        this.owner = owner;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setBalcony(char c) {
        switch (c) {
            case 'Y':
                this.balcony = true;
                break;
            case 'N':
                this.balcony = false;
                break;
            default:
                System.out.println("Wrong input. Balcony can not be determined! Acceptable: 'Y' or 'N'");
                break;
        }
    }

    public void setNumberOfWindows(int count) {
        this.numberOfWindows = count;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getSize() {
        return size;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public String getOwner() {
        return owner;
    }
    
    public static void setConstructionCompany(String company){
        constructionCompany = company; //kell elé a House. vagy nem; House.-al át tudom adni objektumnak is, anélkül nem
    }
    
    public static String getConstructionCompany(){
        return constructionCompany; //kell elé a House. vagy nem; House.-al át tudom adni objektumnak is, anélkül nem
    }

    @Override
    public String toString() {
        return "[Size: " + size + "    Number of windows: " + numberOfWindows + "    Is balcony: " + (balcony ? "Yes" : "No")
                + "    Owner: " + (owner != null ? owner : "---") + "    Construciton Company: " + constructionCompany;
    }

    public void sell(String newOwner) {
        this.owner = newOwner;
    }
}
