package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.OperationLog;
import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerServices;

import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        WaterContainer beczka = WaterContainer.create("Beczka", 100, 50);
        WaterContainer mauzer = WaterContainer.create("Mauzer", 1000, 200);
        WaterContainer konewka = WaterContainer.create("Konewka", 20, 5);
        WaterContainer wiadro = WaterContainer.create("Wiadro", 35, 3);

        List<WaterContainer> waterContainerList = null;//List.of(beczka, mauzer, wiadro, konewka);

        beczka.addWater(60);
        System.out.println(beczka);

        beczka.addWater(-30);
        beczka.addWater(70);

        beczka.pourWater(mauzer, 30);
        System.out.println(beczka);

        Optional<WaterContainer> containerWithTheMostWaterValue = WaterContainerServices.findContainerWithTheMostWaterValue(waterContainerList);
        System.out.println(containerWithTheMostWaterValue);

        Optional<WaterContainer> theMostFilledContainer = WaterContainerServices.findTheMostFilledContainer(waterContainerList);
        System.out.println(theMostFilledContainer);






    }
}
