/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oophw1018Community;

import oophw1018House.House;

/**
 *
 * @author Peter
 */
public class Community {

    House h1;
    House h2;
    House h3;

    public Community(House h1, House h2, House h3) {
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
    }

    public void setH1(House house){
        this.h1=house;
    }
    
    public House getH1(){
        return h1;
    }
    
    public void setH2(House house){
        this.h2=house;
    }
    
    public House getH2(){
        return h2;
    }
    
    public void setH3(House house){
        this.h3=house;
    }
    
    public House getH3(){
        return h3;
    }
    
    @Override
    public String toString() {
        return "[" + "Size: " + h1.getSize() + "    Owner: " + h1.getOwner()
                + "\nSize: " + h2.getSize() + "    Owner: " + h2.getOwner()
                + "\nSize: " + h3.getSize() + "    Owner: " + h3.getOwner() + "]";
    }
}
