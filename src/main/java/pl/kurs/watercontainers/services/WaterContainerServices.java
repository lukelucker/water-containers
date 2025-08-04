package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class WaterContainerServices {

    public static Optional<WaterContainer> findContainerWithTheMostWaterValue(List<WaterContainer> waterContainerList) {
        return waterContainerList.stream()
                .max(Comparator.comparingDouble(WaterContainer::getCurrentWaterAmount));
    }


}
