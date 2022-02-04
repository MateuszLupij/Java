package com.company.src.company;

import com.company.src.company.creatures.Human;
import com.company.src.company.devices.Car;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoggerTranzakcji {

    LocalDateTime kiedyDoTranzakcji;
    Human kupujacy;
    Human sprzedajacy;
    double  cena;

    public LoggerTranzakcji(LocalDateTime kiedyDoTranzakcji, Human kupujacy, Human sprzedajacy, double cena) {
        this.kiedyDoTranzakcji = kiedyDoTranzakcji;
        this.kupujacy = kupujacy;
        this.sprzedajacy = sprzedajacy;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "log tranzakcji" +
                "czas= " + kiedyDoTranzakcji +
                ", kupujacy=" + kupujacy.getFirstName() + " " + kupujacy.getLastName()+
                ", sprzedajacy=" + sprzedajacy.getFirstName() + " " + sprzedajacy.getLastName()+
               ", przedmiotTranzakcji=" + cena;
    }
}
