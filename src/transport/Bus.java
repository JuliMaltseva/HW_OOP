package transport;

public class Bus extends Transport{
    public Bus(String brand, String model, Integer year, String country, String color, int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " год выпуска, " + "страна сборки - " +
                country + ", цвет кузова - " + color + ", " + maxSpeed +  " км/ч.";
    }
}
