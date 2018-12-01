package com.ddlab.rnd.type2;

public class DeviceAdapter implements Charger {
    Device device;

    public DeviceAdapter(Device device) {
        this.device = device;
    }

    public void chargeDevice(String charger) {
        device.getCharge(charger);
    }

    public String getCharger() {
        return "charger";
    }
}