package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        double carFuelAmount = Double.parseDouble(tokens[1]);
        double carConsumption = Double.parseDouble(tokens[2]);
        tokens = scanner.nextLine().split(" ");
        double truckFuelAmount = Double.parseDouble(tokens[1]);
        double truckConsumption = Double.parseDouble(tokens[2]);
        double truckTankCapacity= Double.parseDouble(tokens[3]);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", new Car(carFuelAmount, carConsumption));
        vehicles.put("Truck", new Truck(truckFuelAmount, truckConsumption));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            switch (commandName) {

                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(liters);

                    break;
            }
        }
    }
}
