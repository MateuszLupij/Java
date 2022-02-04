package com.company.src.company;

import com.company.src.company.creatures.Human;
import com.company.src.company.creatures.Pet;
import com.company.src.company.devices.Car;
import com.company.src.company.devices.Electric;
import com.company.src.company.devices.LPG;
import com.company.src.company.devices.Phone;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Pet dog = new Pet("Cocker");
        dog.name = "Luna";
        System.out.println("Pies nazywa się: " + dog.name);
        System.out.println(dog.name + " waży: " + dog.getWeight() + " kg");

        dog.feed();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.feed();
        dog.feed();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.feed();


        Pet cat = new Pet("dachowiec");
        cat.name = "Kika";
        System.out.println("Kot nazywa się: " + cat.name);
        System.out.println("Kot waży: " + cat.getWeight() + " kg");
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.feed();
        cat.feed();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.feed();
        Human me = new Human();

        /*me.sex = "men";
        me.FirstName = "Mateusz";
        me.LastName = "Lupij";
        me.age = 29;
        me.introduceYourself();
        System.out.println(me.species);
        me.feed();




        Human myWife = new Human();
        myWife.FirstName = "Agnieszka";
        myWife.LastName = "xxxx";
        myWife.introduceYourself();
        me.setSalary(21000.0);
        me.pet = dog;*/




        Car vehicle1 = new LPG("opel", "silver", 20.000, "szary", 2008);
        //me.setVehicle(vehicle);

        Car vehicle = new Electric("opel", "silver", 20.000,"czarny", 2000);

        System.out.println(vehicle.equals(vehicle1));
        System.out.println(me);
        System.out.println(vehicle);
        vehicle.turnOn();
        Phone nokia = new Phone("Nokia","czerwony", 4.5, "zero","android", 2000, 100.0);
        System.out.println(nokia);
        nokia.turnOn();
        System.out.println("...");
        Human seller = new Human(3);
        seller.setFirstName("Mateusz");
        seller.setLastName("Lupij");
        seller.setSex("male");
        seller.setAge(29);
        Pet dogg = new Pet("Spaniel");
        seller.pet = dogg;
        System.out.println(seller);
        Human buyer = new Human(2);
        buyer.cash = 100;
        buyer.setFirstName("Agnieszka");
        buyer.setLastName("Michalowska");
        buyer.setSex("female");
        buyer.setAge(29);
        System.out.println(buyer);


        dogg.sell(seller,buyer,99d);
        System.out.println(seller);
        System.out.println(buyer);
        //seller.setVehicle(fiat);
        System.out.println(seller);
        buyer.setCash(1000.00);

        System.out.println("....");
        LPG opel = new LPG("opel", "vectra",20.000, "silver", 1998);
        LPG mercedes = new LPG("Mercedes", "SA", 21.000,"BLUE",2003);
        System.out.println("Przypisuje sprzedawdcy samochody");
        seller.setCar(0,opel);
        seller.setCar(1,mercedes);
        System.out.println("sprawdzamy czy są w garażu");
        System.out.println(seller);
        System.out.println("dochodzi do transakcji - sprzedaje mercedesa");
        mercedes.sell(seller,buyer,0.99);
        System.out.println("przed zakupem");
        System.out.println(buyer);
        System.out.println("po");
        System.out.println(seller);

        System.out.println(".....");

        Human Romek = new Human(2);
        Romek.setFirstName("Romek");
        Romek.setLastName("Wozniak");
        Romek.setCash(2000);

        mercedes.sell(buyer, Romek, 1.00);

        mercedes.pokazWlascicieliLadnie();
        //System.out.println(mercedes.czySprzedal(buyer,Romek));

        Car[] garage = seller.getGarage();


        mercedes.sell(Romek,seller, 1.0);
        System.out.println("...");
        mercedes.pokazWlascicieliLadnie();

        System.out.println(Arrays.toString(seller.getGarage()));

        opel.sell(seller,Romek, 5.0);
        System.out.println("...");
        opel.pokazWlascicieliLadnie();
        System.out.println(Arrays.toString(Romek.getPosortowaneSamochody()));
        opel.sell(Romek,seller,2.0);
        opel.sell(seller,Romek,2.0);
        System.out.println(Arrays.toString(seller.getPosortowaneSamochody()));
        opel.sell(Romek,seller,2.0d);
        System.out.println(Arrays.toString(seller.getPosortowaneSamochody()));
        opel.pokazWlascicieliLadnie();

        System.out.println("...Czy sprzedal...");
        opel.czySprzedal(seller,Romek);
        opel.sell(seller,buyer,2.0);
        opel.czySprzedal(seller,buyer);

        Car star = new LPG("passerati","passerati", 11.00,"czarny",2005);
        seller.setCarNaPierwszymWolnymMiejscu(star);

        star.sell(seller,Romek,2.0);
        System.out.println("====");
        System.out.println(star.czySprzedal(seller,Romek));
        System.out.println("====");
        opel.wyswietlTranzakcje();





































    }
}
