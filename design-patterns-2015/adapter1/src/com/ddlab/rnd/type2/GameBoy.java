package com.ddlab.rnd.type2;

public class GameBoy implements Device {
    public void getCharge(String charger) {
        System.out.println("The Game Boy is being charged by the " + charger + "...");
    }
}