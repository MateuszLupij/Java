package com.company.src.company.devices;

import com.company.src.company.creatures.Human;
import com.company.src.company.Salleable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Device implements Salleable {
    String color;

    int rokProdukcji;

    List<Human> listaWlascicieliSamochodu = new ArrayList<>();


    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public Car(String producer, String model, Double value, String color, int rokProdukcji) {
        super(producer, model, value);
        this.color = color;
        this.rokProdukcji = rokProdukcji;
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

    /*@Override
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
    }*/

    public abstract void refuel();

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        //TODO jaki samochod jest do sprzedania albo kupienia skoro nie ma o nim info
        Car[] garage = seller.getGarage();
        List<Car> samochody = new ArrayList<>(Arrays.asList(garage));
        boolean tenSamochodJestUsprzedajacego = samochody.contains(this);
        int indexTegoSamochoduWTablicy = -1;
        if(tenSamochodJestUsprzedajacego){
            indexTegoSamochoduWTablicy = samochody.indexOf(this);
        }

        if(!tenSamochodJestUsprzedajacego){
            System.out.println("Tego samochodu nie ma u sprzedajacego");
            try {
                throw new NieMaTakiegoSamochodu();
            } catch (NieMaTakiegoSamochodu e) {
                e.printStackTrace();
            }
        }

        boolean czyJestWolneMiejsce = false;
        for (Car car:garage) {
            if(car==null){
                czyJestWolneMiejsce = true;
            }
        }
        if(!czyJestWolneMiejsce){
            System.out.println("Nie ma tyle miejsca");
            try {
                throw new NieMiejscaWGarazu();
            } catch (NieMiejscaWGarazu e) {
                e.printStackTrace();
            }
        }

        if(value > buyer.getCash()){
            System.out.println("Nie ma tyle pieniedzy");
            try {
                throw new NieMaKasy();
            } catch (NieMaKasy e) {
                e.printStackTrace();
            }
        }
        buyer.setCarNaPierwszymWolnymMiejscu(this);
        //usuwam samochod

        System.out.println(indexTegoSamochoduWTablicy);
        seller.getCar(indexTegoSamochoduWTablicy);

        buyer.setCash(buyer.getCash() - value);
        seller.setCash(seller.getCash() + value);

        listaWlascicieliSamochodu.add(seller);
        System.out.println("...");
    }

    public List<Human> getListaWlascicieliSamochodu() {
        return listaWlascicieliSamochodu;
    }

    public void setListaWlascicieliSamochodu(List<Human> listaWlascicieliSamochodu) {
        this.listaWlascicieliSamochodu = listaWlascicieliSamochodu;
    }
}
