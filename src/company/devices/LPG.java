package com.company.src.company.devices;

public class LPG extends Car {
    public LPG(String producer, String model, Double value, String color) {
        super(producer, model, value, color);
    }

    @Override
    public void refuel() {
        System.out.println("implementacja metody refuel w LPG");
    }
}
