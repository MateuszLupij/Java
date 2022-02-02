package com.company.src.company;

import com.company.src.company.creatures.Human;
import com.company.src.company.creatures.Pet;
import com.company.src.company.devices.Car;
import com.company.src.company.devices.Electric;
import com.company.src.company.devices.LPG;
import com.company.src.company.devices.Phone;

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




        Car vehicle = new Electric("opel", "silver", 20.000,"czarny");
        Car vehicle1 = new LPG("opel", "silver", 20.000, "szary");
        me.setVehicle(vehicle);

        System.out.println(vehicle.equals(vehicle1));
        System.out.println(me);
        System.out.println(vehicle);
        vehicle.turnOn();
        Phone nokia = new Phone("Nokia","czerwony", 4.5, "zero","android", 2000, 100.0);
        System.out.println(nokia);
        nokia.turnOn();
        System.out.println("========ZADANIE 8========");
        Human seller = new Human();
        seller.setFirstName("Mateusz");
        seller.setLastName("Lupij");
        seller.setSex("male");
        seller.setAge(29);
        Pet dogg = new Pet("Spaniel");
        seller.pet = dogg;
        System.out.println(seller);
        Human buyer = new Human();
        buyer.cash = 100;
        buyer.setFirstName("Agnieszka");
        buyer.setLastName("Michalowska");
        buyer.setSex("female");
        buyer.setAge(29);
        System.out.println(buyer);


        dogg.sell(seller,buyer,99d);
        System.out.println(seller);
        System.out.println(buyer);
        LPG fiat = new LPG("opel", "vectra",20.000, "silver");
        seller.setVehicle(fiat);
        System.out.println(seller);













    }
}
