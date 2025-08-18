package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

public class OperationLog implements Serializable {
    private static final long serialVersionUID = 42L;

    public enum OperationType {ADD, SUBTRACT}

    private final Timestamp timestamp;
    private final OperationType operationType;
    private final WaterContainer waterContainer;
    private final double waterAmount;
    private final boolean success;

    private OperationLog(Timestamp timestamp, OperationType operationType, WaterContainer waterContainer, double waterAmount, boolean success) {
        this.timestamp = timestamp;
        this.operationType = operationType;
        this.waterContainer = waterContainer;
        this.waterAmount = waterAmount;
        this.success = success;
    }

    public static OperationLog create(OperationType operationType, WaterContainer waterContainer, double waterAmount, boolean success) {
        return new OperationLog(Timestamp.from(Instant.now()), operationType, waterContainer, waterAmount, success);
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "timestamp=" + timestamp +
                ", operationType=" + operationType +
                ", waterContainer=" + waterContainer +
                ", waterAmount=" + waterAmount +
                ", success=" + success +
                '}';
    }
}
