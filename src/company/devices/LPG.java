package com.company.src.company.devices;

import com.company.src.company.creatures.Human;

public class LPG extends Car {
    public LPG(String producer, String model, Double value, String color, int rokProdukcji) {
        super(producer, model, value, color, rokProdukcji);
    }

    @Override
    public void refuel() {
        System.out.println("implementacja metody refuel w LPG");
    }

}
