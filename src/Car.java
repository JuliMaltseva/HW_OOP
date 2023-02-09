import java.util.Objects;

public class Car {
    public final String brand;
    public final String model;
    public double engineVolume;
    public String color;
    public final String year;
    public final String country;

    public Car(String brand, String model, double engineVolume, String color, String year, String country) {
        this.brand = ValidateParameters.validateCarParameters(brand);
        this.model = ValidateParameters.validateCarParameters(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateCarColor(color);
        this.year = validateYear(year);
        this.country = ValidateParameters.validateCarParameters(country);
    }

    public static double validateEngineVolume(double value) {
        return value <= 0 ? 1.5 : value;
    }

    public static String validateCarColor(String value) {
        return ValidateParameters.validateString(value, "белый");
    }

    public static String validateYear(String value) {
        return ValidateParameters.validateString(value, "2000");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " год выпуска, " + "страна сборки - " + country +
                ", цвет кузова - " + color + ", объем двигателя - " + engineVolume + " л.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color) && year.equals(car.year) && country.equals(car.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, year, country);
    }
}


