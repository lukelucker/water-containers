package pl.kurs.watercontainers.models;

public class WaterContainer {

    private String name;
    private double maxCapacity;
    private double currentWaterAmount;

    public WaterContainer(String name, double maxCapacity, double currentWaterAmount) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentWaterAmount = currentWaterAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getCurrentWaterAmount() {
        return currentWaterAmount;
    }

    public void setCurrentWaterAmount(double currentWaterAmount) {
        this.currentWaterAmount = currentWaterAmount;
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", currentWaterAmount=" + currentWaterAmount +
                '}';
    }
}
