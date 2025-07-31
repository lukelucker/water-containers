package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;

public class Application {

    public static void main(String[] args) {

        WaterContainer beczka = WaterContainer.create("Beczka", 100, 50);
        WaterContainer mauzer = WaterContainer.create("Mauzer", 1000, 200);

        beczka.addWater(60);
        System.out.println(beczka);

        beczka.pourWater(mauzer, 30);
        System.out.println(beczka);

    }
}
