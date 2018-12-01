package com.ddlab.rnd.type2;

public class WallOutlet implements Charger {
    String charger;

    public WallOutlet(String charger) {
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
