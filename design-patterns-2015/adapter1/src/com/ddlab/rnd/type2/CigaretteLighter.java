package com.ddlab.rnd.type2;

public class CigaretteLighter implements Charger {
    String charger;

    public CigaretteLighter(String charger) {
        setCharger(charger);
    }

    public void chargeDevice(String charger) {
        System.out.println("The " + charger + " is ready");
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }
}