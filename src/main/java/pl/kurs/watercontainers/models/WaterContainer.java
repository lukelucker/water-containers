package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WaterContainer implements Serializable {
    private static final long serialVersionUID = 42L;

    private final List<OperationLog> logs = new ArrayList<>();

    private String name;
    private double maxCapacity;
    private double currentWaterAmount;

    private WaterContainer(String name, double maxCapacity, double currentWaterAmount) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentWaterAmount = currentWaterAmount;
    }

    public static WaterContainer create(String name, double maxCapacity, double currentWaterAmount) {
        if (maxCapacity <= 0) {
            throw new RuntimeException("Bad value for max capacity!");
        }
        if (currentWaterAmount < 0) {
            throw new RuntimeException("Bad value for current water amount!");
        }
        if (currentWaterAmount > maxCapacity) {
            throw new RuntimeException("Current water amount can't be bigger than max capacity!");
        }
        return new WaterContainer(name, maxCapacity, currentWaterAmount);
    }

    public void addWater(double value) {
        OperationLog log = null;
        if (value <= 0) {
            System.out.println("Wartośc powinna być większa od 0!");
            log = OperationLog.create(OperationLog.OperationType.ADD, this, value, false);
        } else if (value + this.currentWaterAmount > maxCapacity) {
            System.out.println("Za dużo wody do dolania!");
            log = OperationLog.create(OperationLog.OperationType.ADD, this, value, false);
        } else {
            this.currentWaterAmount += value;
            log = OperationLog.create(OperationLog.OperationType.ADD, this, value, true);
        }
        logs.add(log);
    }

    public void subtractWater(double value) {
        OperationLog log = null;
        if (value <= 0) {
            System.out.println("Wartośc powinna być większa od 0!");
            log = OperationLog.create(OperationLog.OperationType.SUBTRACT, this, value, false);
        } else if (value - this.currentWaterAmount < 0) {
            System.out.println("Za dużo wody do odlania!");
            log = OperationLog.create(OperationLog.OperationType.SUBTRACT, this, value, false);
        } else {
            this.currentWaterAmount -= value;
            log = OperationLog.create(OperationLog.OperationType.SUBTRACT, this, value, true);
        }
    }

    public void pourWater(WaterContainer source, double value) {
      if (source.subtractIsPossible(value) && this.addIsPossible(value)) {
          source.subtractWater(value);
          this.addWater(value);
      } else {
          System.out.println("Operacja nie jest możliwa do wykonania.");
      }
    }

    private boolean addIsPossible(double value) {
        if (currentWaterAmount + value > maxCapacity) {
            System.out.println("Too much water to add");
            return false;
        }
        return true;
    }

    private boolean subtractIsPossible(double value) {
        if (currentWaterAmount - value < 0) {
            System.out.println("Too much water to subtract");
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return currentWaterAmount == 0;
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

    public List<OperationLog> getLogs() {
        return logs;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WaterContainer that = (WaterContainer) object;
        return Double.compare(maxCapacity, that.maxCapacity) == 0 && Double.compare(currentWaterAmount, that.currentWaterAmount) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, currentWaterAmount);
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
