package com.company.src.company.devices;

public class Electric extends Car{
    public Electric(String producer, String model, Double value, String color) {
        super(producer, model, value, color);
    }

    @Override
    public void refuel() {
        System.out.println("implementracja metody refuel w electric");
    }

}
