package transport;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

import static transport.ValidateParameters.*;

public class Car extends Transport {
    private double engineVolume;
    private String transmission;
    private final String bodyStyle;
    private String registrationNumber;
    private final int numberOfSeats;
    private static String typeOfTire;
    private static Key key;

    /**
     *
     */

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               Integer year,
               String country,
               String transmission,
               String bodyStyle,
               String registrationNumber,
               Integer numberOfSeats,
               String typeOfTire,
               Integer maxSpeed,
               Key key) {
        super(brand, model, year, country, color, maxSpeed);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.transmission = validateTransmission(transmission);
        this.bodyStyle = validateBodyStyle(bodyStyle);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.numberOfSeats = validateNumberOfSeats(numberOfSeats);
        this.typeOfTire = validateTypeOfTire(typeOfTire);
        this.key = key;
    }

    //validation
    public static double validateEngineVolume(double value) {
        return value <= 0 ? 1.5 : value;
    }

    @Override
    public String validateTransportColor(String value) {
        return validateString(value, "белый");
    }

    @Override
    public String validateYear(Integer value) {
        return validateString(String.valueOf(value), "2000");
    }

    public static String validateTransmission(String value) {
        return validateString(value, "механическая");
    }

    public static String validateBodyStyle(String value) {
        return validateString(value, "седан");
    }

    public static String validateRegistrationNumber(String registrationNumber) {
        if (Pattern.matches("[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx][0-9]{3}[АВЕКМНОРСТУХавекмнорстухABEKMHOPCTYXabekmhopctyx]{2}[0-9]{3}", registrationNumber)) {
            return registrationNumber;
        } else {
            return registrationNumber = "a001aa011";
        }
    }

    public static int validateNumberOfSeats(Integer value) {
        return value <= 0 ? 4 : value;
    }

    public static String validateTypeOfTire(String value) {
        return validateString(value, isThisASummerTire());
    }

    public static String isThisASummerTire() {
        String currentMonth = String.valueOf(LocalDate.now().getMonth());
        switch (currentMonth) {
            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
            case "APRIL":
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                typeOfTire = "зимняя";
                break;
            case "MAY":
            case "JUNE":
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                typeOfTire = "летняя";
            default:
                throw new RuntimeException("некорректно указан месяц");
        }
        return typeOfTire;
    }

    //getters & setters
    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public static String getTypeOfTire() {
        return typeOfTire;
    }

    public static void setTypeOfTire(String typeOfTire) {
        Car.typeOfTire = typeOfTire;
    }


    @Override
    public String toString() {
               return brand + " " + model + ", " + year + " год выпуска, " + "страна сборки - " +
                country + ", цвет кузова - " + color + ", объем двигателя - " +
                engineVolume + " л." + ", коробка передач - " + transmission +
                ", тип кузова - " + bodyStyle + ", регистрационный номер: " + registrationNumber +
                ", количество мест: " + numberOfSeats + ", тип резины: " + typeOfTire +
                ", максимальная скорость передвижения: " + maxSpeed +  " км/ч.";
           }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 &&
                numberOfSeats == car.numberOfSeats && brand.equals(car.brand) &&
                model.equals(car.model) && color.equals(car.color) &&
                year.equals(car.year) && country.equals(car.country) &&
                transmission.equals(car.transmission) && bodyStyle.equals(car.bodyStyle) &&
                registrationNumber.equals(car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, year, country,
                transmission, bodyStyle, registrationNumber, numberOfSeats);
    }

    public static class Key {
        private final boolean isRemoteEngineStart;
        private final boolean isKeylessEntry;

        public Key(boolean isRemoteEngineStart, boolean isKeylessEntry) {
            this.isRemoteEngineStart = validateBoolean(isRemoteEngineStart);
            this.isKeylessEntry = validateBoolean(isKeylessEntry);
        }

        public boolean isRemoteEngineStart() {
            return isRemoteEngineStart;
        }

        public boolean isKeylessEntry() {
            return isKeylessEntry;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "isRemoteEngineStart=" + isRemoteEngineStart +
                    ", isKeylessEntry=" + isKeylessEntry +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return isRemoteEngineStart == key.isRemoteEngineStart &&
                    isKeylessEntry == key.isKeylessEntry;
        }

        @Override
        public int hashCode() {
            return Objects.hash(isRemoteEngineStart, isKeylessEntry);
        }
    }


}




