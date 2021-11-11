package Vehicles;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {
    private static final double AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);


    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.getFuelConsumption();
        if (fuelNeeded > this.getFuelQuantity()) {
            return "Car needs refueling";
        } else this.setFuelConsumption(this.getFuelQuantity() - distance);
        DecimalFormat formater = new DecimalFormat("##.##");
        return String.format("Car travveled %s km", formater.format(distance));
    }
}
