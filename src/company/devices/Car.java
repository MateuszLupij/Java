package com.company.src.company.devices;

import com.company.src.company.LoggerTranzakcji;
import com.company.src.company.creatures.Human;
import com.company.src.company.Salleable;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Device implements Salleable, Comparable<Car> {
    String color;

    int rokProdukcji;

    List<Human> listaWlascicieliSamochodu = new ArrayList<>();
    List<LoggerTranzakcji> loggerTranzakcji = new ArrayList<>();



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
    public int compareTo(Car o) {
        return this.rokProdukcji - o.rokProdukcji;
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

    public boolean czyWlasciciel(Human osobaDoSprawdzenia){
        for (Human human: listaWlascicieliSamochodu) {
            if(human.equals(osobaDoSprawdzenia)){

                System.out.println(osobaDoSprawdzenia + " była włascicielem tego pojazdu");
                return true;
            }
        }
        return false;
    }
    public boolean czySprzedal(Human sprzedajacy, Human kupujacy){
        /*System.out.println(listaWlascicieliSamochodu.size() + " aktualna");*/
        if(listaWlascicieliSamochodu.size() <= 1){
            System.out.println("Nie ma kupujacego w liscie");            return false;
        }
        int indexKupujacego = listaWlascicieliSamochodu.indexOf(kupujacy);
        Human human = listaWlascicieliSamochodu.get(indexKupujacego - 1);
        if(sprzedajacy == human){
            return true;
        } else {
            return false;
        }
    }

    public void pokazWlascicieliLadnie(){
        int index = 0;
        for (Human h : listaWlascicieliSamochodu) {
            System.out.println("historia włascicieli["+(index+1) + " " + h.getFirstName() + " " + h.getLastName()+" ]"  );
            index ++;
        }
    }

    @Override
   public void turnOn() {
        System.out.println("Przekręcam klucz");
    }

    public void wyswietlLiczneTranzakcjiTegoSamochodu(){
        System.out.println("SAMOCHOD byl sprzedany " + listaWlascicieliSamochodu.size()+1);
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
        Car[] garageBuyera = buyer.getGarage();
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
        for (Car car:garageBuyera) {
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

        //ustawiam wlasciciela
        if(listaWlascicieliSamochodu.size() == 0) {
            listaWlascicieliSamochodu.add(seller);
            listaWlascicieliSamochodu.add(buyer);
        } else {

            listaWlascicieliSamochodu.add(buyer);
        }

        //sprawdzam czy sprzedajacy jest ostatnim wlasiccielem pojazdu
        Human ostatniSprzedajacy = listaWlascicieliSamochodu.get(listaWlascicieliSamochodu.size() - 2);



        if((ostatniSprzedajacy == seller)){
            System.out.println("Ten posiadacz jest ostatnim wlascicielem");
        }else {
            System.out.println("nie jest ostatnim właścicielem");
        }

        LoggerTranzakcji trazakcja = new LoggerTranzakcji(LocalDateTime.now(),buyer,seller, price);
        loggerTranzakcji.add(trazakcja);
        System.out.println("...");
    }
    public void wyswietlTranzakcje(){
        for (LoggerTranzakcji l: loggerTranzakcji) {
            System.out.println(l.toString());
        }
    }

    public List<Human> getListaWlascicieliSamochodu() {
        return listaWlascicieliSamochodu;
    }

    public void setListaWlascicieliSamochodu(List<Human> listaWlascicieliSamochodu) {
        this.listaWlascicieliSamochodu = listaWlascicieliSamochodu;
    }
}
