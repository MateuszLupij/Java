package com.company.src.company.devices;

import com.company.src.company.creatures.Human;

public class Disel extends Car{
    public Disel(String producer, String model, Double value, String color, int rokProdukcji) {
        super(producer, model, value, color, rokProdukcji);
    }

    @Override
    public void refuel() {
        System.out.println("Implementacja metody refuel w diesel");
    }


}
