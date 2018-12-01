package com.ddlab.rnd.type2;

//Client
public class CellPhone implements Device {

    public void getCharge(String charger) {
        System.out.println("The Cell Phone is being charged by the " + charger + "...");
    }
}
