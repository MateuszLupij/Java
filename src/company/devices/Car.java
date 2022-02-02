package com.company.src.company.devices;

import com.company.src.company.creatures.Human;
import com.company.src.company.Salleable;

import java.util.Objects;

public abstract class Car extends Device implements Salleable {
    String color;

    



    public Car(String producer, String model, Double value, String color) {
        super(producer, model, value);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(color, car.color) && Objects.equals(model, car.model) && Objects.equals(value, car.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, color, model, value);
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
   public void turnOn() {
        System.out.println("Przekręcam klucz");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getVehicle() == null){
            System.out.println("Nie masz samochodu do sprzedania.");
            return;
        }
        if ( buyer.cash <=price){
            System.out.println("Przykro mi, nie masz kasy na kupno tego samochodu.");
            return;
        }
        buyer.cash = buyer.cash - price;
        seller.cash = seller.cash + price;
        buyer.setVehicle(seller.getVehicle());
        seller.setVehicle(null);
        System.out.println("Samochodo został sprzedany."+ buyer.getVehicle() + " za kwotę " + price);
    }

    public abstract void refuel();


}
