package com.ddlab.rnd.type2;

public class ChargeDevices {
    public static void main(String[] args) {
        System.out.println("-- Device Charging Application --");
        System.out.println();
// create the chargers
        Charger lighter = new CigaretteLighter("cigarette lighter");
        Charger outlet = new WallOutlet("wall outlet");
// create the devices
        Device gameBoy = new GameBoy();
        Device cellPhone = new CellPhone();
// create the device adapters
        Charger device01 = new DeviceAdapter(gameBoy);
        Charger device02 = new DeviceAdapter(cellPhone);
        String charger01 = lighter.getCharger();
        String charger02 = outlet.getCharger();
// charge the devices
        device01.chargeDevice(charger01);
        device02.chargeDevice(charger01);
        device01.chargeDevice(charger02);
    }
}
