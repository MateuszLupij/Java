package com.company.src.company.devices;

public abstract class Device {
    final String producer;
    final String model;
   public Double value;


    public Device(String producer, String model, Double value){
        this.producer = producer;
        this.model = model;
        this.value = value;


    }
   public abstract void turnOn();


}
