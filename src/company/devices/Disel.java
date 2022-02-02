package com.company.src.company.devices;

public class Disel extends Car{
    public Disel(String producer, String model, Double value, String color) {
        super(producer, model, value, color);
    }

    @Override
    public void refuel() {
        System.out.println("Implementacja metody refuel w diesel");
    }
}
