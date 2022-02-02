package com.company.src.company.devices;

import com.company.src.company.devices.Device;

import java.net.URL;
import java.util.List;

public class Phone extends Device {
    String producer;
    String model;
    Double screenView;
    String os;
    Integer yearOfProduction;
    static final String KONKRETNA_APLIKACJA = "FindMyDevice";
    static final String DOMYSLNY_ADRES = "149.156.96.52:80";
    static final Double DOMYSLNA_WERSJA = 1.2;




    public Phone(String producer, String color, Double screenView, String model,String os, Integer yearOfProduction,Double value){
        super(producer,model,value);


        this.screenView = screenView;
        this.os = os;
        this.yearOfProduction = yearOfProduction;
        this.producer = producer;
        this.model = model;



    }

    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", screenView=" + screenView +
                ", os='" + os + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    @Override
   public void turnOn() {
        System.out.println("wciskam przycisk");
    }

    public void installAnnApp(String aplikacjaDoZainstalownia){

    }

    public void installAnnApp(String aplikacjaDoZainstalownia, Double wersja){

    }
    public void installAnnApp(String aplikacjaDoZainstalownia,Double wersja, String adresSerwera){

    }
    public void installAnnApp(List<String> listaNazwAplikacji){
        for (String aplikacja: listaNazwAplikacji) {
            System.out.println("Aplikacja do zainstalowania" + aplikacja);
        }
    }
    public void installAnnApp(URL url){
        installAnnApp(KONKRETNA_APLIKACJA, DOMYSLNA_WERSJA, DOMYSLNY_ADRES,url);
    }
    public void installAnnApp(String aplikacjaDoZainstalowania,Double wersja, String adresSerwera, URL url){

    }
}
