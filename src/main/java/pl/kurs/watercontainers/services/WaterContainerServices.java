package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class WaterContainerServices {

    public static Optional<WaterContainer> findContainerWithTheMostWaterValue(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList).orElseGet(Collections::emptyList)
                .stream()
                .max(Comparator.comparingDouble(WaterContainer::getCurrentWaterAmount));
    }

    public static Optional<WaterContainer> findTheMostFilledContainer(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList).orElseGet(Collections::emptyList)
                .stream()
                .max(Comparator.comparingDouble(WaterContainerServices::calculateFillingRatio));
    }

    public static List<WaterContainer> findAllEmptyContainers(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList).orElseGet(Collections::emptyList)
                .stream()
                .filter(WaterContainer::isEmpty)
                .toList();
    }

    private static double calculateFillingRatio(WaterContainer waterContainer) {
        return waterContainer.getCurrentWaterAmount() / waterContainer.getMaxCapacity();
    }


}
