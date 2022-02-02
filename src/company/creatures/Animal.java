package com.company.src.company.creatures;

import com.company.src.company.Salleable;

public abstract class Animal implements Salleable, Feedable {

    public String species;
    private Double weight;
    public String name;
    Boolean alive;

    public Double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return species;

    }

    public Animal(String species) {
        this.species = species;
        alive = true;


        if (this.species == "Cocker") {
            this.weight = 10.0;
        } else if (this.species == "dachowiec") {
            this.weight = 6.0;
        }else{
            this.weight = 1.0;
        }

    }

    public void feed() {
        if (this.weight > 0) {

            this.weight++;
            System.out.println("Waga zwierzaka po nakarmieniu wynosi: " + weight + " kg");

        } else if (this.weight <= 0.0) {
            System.out.println("Przykro mi " + name + " zdechła, nie nakarmisz zdechłego zwierzaka");


        }
    }

    public void takeForAWalk() {
        if (this.weight > 0) {

            this.weight--;
            System.out.println("Zwierzak poszedl na spacer, jego waga wynosi: " + weight + " kg");
        } else if (this.weight == 0) {
            System.out.println("Niestety " + name + " zdechła, nie wyprowadzisz zdechłego zwierzaka");


        }

    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {

        if (seller.pet instanceof Human){
            System.out.println("Nie handluj ludzmi");
            return;
        }

        if (seller.pet == null){
            System.out.println("Nie masz zwierzaka do sprzedania.");
            return;
        }
        if ( buyer.cash <=price){
            System.out.println("Przykro mi, nie masz kasy na kupno tego zwierzaka.");
            return;
        }
        buyer.cash = buyer.cash - price;
        seller.cash = seller.cash + price;
        buyer.pet = seller.pet;
        seller.pet = null;
        System.out.println("Zwierzak został sprzedany."+ buyer.pet + " za kwotę " + price);
    }
}
