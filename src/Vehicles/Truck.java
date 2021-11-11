package Vehicles;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {
    private static final double AC_CONSUMPTION = 1.6;
    private static final double REFILL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_CONSUMPTION);

    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFILL_PERCENTAGE);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()) {
            return "Truck needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("Truck travelled %s km", decimalFormat.format(distance));
    }
}
