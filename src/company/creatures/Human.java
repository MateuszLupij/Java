package com.company.src.company.creatures;

import com.company.src.company.creatures.Animal;
import com.company.src.company.devices.Car;
import com.company.src.company.devices.NieMaKasy;
import com.company.src.company.devices.NieMaTakiegoSamochodu;
import com.company.src.company.devices.NieMiejscaWGarazu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Human extends Animal {

    public static final double SALARY = 21000.0;
    public static final String HOMO_SAPIENS = "homo sapiens";
    String sex;
    String FirstName;
    String LastName;
    Integer age;
    private Double salary;
    public Animal pet;

    private Car[] garage;
    public double cash;

    public Human() {
        super(HOMO_SAPIENS);
        garage = new Car[1];
        this.salary = SALARY;
    }

    public Human(int rozmiarGarazu) {
        super(HOMO_SAPIENS);
        garage = new Car[rozmiarGarazu];
    }


    public Car getCar(int zKtoregoMiejscaWGarazu) {
        if (garage.length < zKtoregoMiejscaWGarazu) {
            System.out.println(" nie ma takiego miejsca w garazu");
            return null;
        }
        Car samochodDoWystawienia;

        samochodDoWystawienia = garage[zKtoregoMiejscaWGarazu];
        if(samochodDoWystawienia ==null){
            System.out.println("Nie ma tekiego auta");
            return null;
        }

        garage[zKtoregoMiejscaWGarazu] = null;


        return samochodDoWystawienia;
    }

    public BigDecimal getSumaWartosciSamochodowWGarazu() {
        BigDecimal sumaWartosci = new BigDecimal(0);
        for (Car samochod : garage) {
            sumaWartosci.add(BigDecimal.valueOf(samochod.value));

        }
        System.out.println("Suma wartosci samochodów w garażu " + sumaWartosci);
        return sumaWartosci;
    }


    public void setCar(int doKtoregoMiejscaWGarazu, Car samochodDoWstawienia) {

        if (garage.length < doKtoregoMiejscaWGarazu) {
            System.out.println("Szukasz miejsca w garazu, którego nie ma");
            return;
        }

        garage[doKtoregoMiejscaWGarazu] = samochodDoWstawienia;
    }
    public void setCarNaPierwszymWolnymMiejscu(Car car){
        try {
            garage[znajdzPierwszeWolneMiejsceWGarazu()] = car;
        }catch (IndexOutOfBoundsException e){
            throw e;
        }
    }
    public int znajdzPierwszeWolneMiejsceWGarazu(){
        int index = 0;
        for (Car car:garage) {
            if(car==null){
                return index;
            }
            index ++;
        }

        return -1;
    }

    public Car[] getPosortowaneSamochody() {
        Comparator<Car> byRokProdukcji = Comparator.comparing(Car::getRokProdukcji);
        Car[] copiaGarazu = Arrays.copyOf(garage, garage.length);
        Arrays.sort(copiaGarazu, byRokProdukcji);
        return copiaGarazu;
    }
   /* public void setVehicle(Car vehicle) {
        if (salary > vehicle.value) {
            System.out.println("Gratulacje, udało Ci się kupic samochód za gotówkę");
            this.vehicle = vehicle;
            return;
        }
        if (salary > (vehicle.value / 12)) {
            System.out.println("Samochód kosztuje przynajmiej 1/12 Twojego wynagrodzenia, gratulacje udalo CI sie kupic samochod na kredyt");
            this.vehicle = vehicle;
            return;
        }
        System.out.println("Niestety, nie stać Cie na samochód, zapisz się na studia ");


    }*/


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Nie można przypisac ujemnej wartosci do wypłaty ! ");
            return;
        }
        System.out.println("Nowe dane został wyslane do ksiegowego. ");
        System.out.println("Prosze stawić się i odebrac aneks do umowy od P. Hani z kadr.");
        System.out.println("ZUS i US zostali poinformowani o zmianie wypłaty, nie ma sensu ukrywać dochodu.");
        this.salary = salary;
    }


    void introduceYourself() {
        System.out.println("My name is " + FirstName);
        System.out.println("My lastname is  " + LastName);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "sex='" + sex + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pet=" + pet +
                ", Moje samochody w garażu=" + Arrays.toString(garage) +
                ", cash=" + cash +
                '}';
    }

    @Override
    public void feed(double foodWeight) {

    }

    public Car[] getGarage() {
        return garage;
    }

    public void setGarage(Car[] garage) {
        this.garage = garage;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
