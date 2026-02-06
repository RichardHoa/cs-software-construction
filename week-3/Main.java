public class Main {
    public static void main(String[] args) {
        MotorBike motorbike = new MotorBike(); 
        motorbike.addFuel(5);
        motorbike.addWeight(10);
        motorbike.run(100);
        System.out.println("Motorbike field left: " + motorbike.getFuelLeft());

        Truck truck = new Truck();
        truck.addFuel(25);
        truck.addWeight(1000);
        truck.run(100);
        System.out.println("Truck field left: " + truck.getFuelLeft());
    }


}


abstract class Vehicle {
    protected double fuelAmount;
    protected double goodsWeight;

    public void addWeight(double weight) {
        this.goodsWeight += weight;
    }

    public void removeWeight(double weight) {
        this.goodsWeight = Math.max(0, this.goodsWeight - weight);
    }

    public void addFuel(double amount) {
        this.fuelAmount += amount;
    }

    public double getFuelLeft() {
        return fuelAmount;
    }

    public abstract void run(double km);
    
    protected abstract double calculateConsumptionPerKm();
}

class MotorBike extends Vehicle {
    @Override
    protected double calculateConsumptionPerKm() {
        // Base: 2L / 100km = 0.02 L/km
        // Extra: 0.1L / 100km for every 10kg = (0.1 / 100) * (weight / 10)
        double baseRate = 0.02;
        double extraRate = (0.1 / 100) * (goodsWeight / 10);
        return baseRate + extraRate;
    }

    @Override
    public void run(double km) {
        double consumed = km * calculateConsumptionPerKm();
        this.fuelAmount = Math.max(0, this.fuelAmount - consumed);
    }
}

class Truck extends Vehicle {
    @Override
    protected double calculateConsumptionPerKm() {
        // Base: 20L / 100km = 0.2 L/km
        // Extra: 1L / 100km for every 1000kg = (1.0 / 100) * (weight / 1000)
        double baseRate = 0.2;
        double extraRate = (1.0 / 100) * (goodsWeight / 1000);
        return baseRate + extraRate;
    }

    @Override
    public void run(double km) {
        double consumed = km * calculateConsumptionPerKm();
        this.fuelAmount = Math.max(0, this.fuelAmount - consumed);
    }
}