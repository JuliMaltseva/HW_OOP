package transport;

import transport.Car;

public class CarAssortment {
    private Car[] cars = new Car[5];

    {
        cars[0] = new Car("Lada", "Granta", 1.7,
                "желтый", 2015, "Россия", "автомат",
                "хэтчбэк", "о123ен011", 4, "",0,
                new Car.Key(true,true));
        cars[1] = new Car("Audi", "A8 50 L TDI quattro", 3.0,
                "черный", 2020, "Германия", "",
                "", "б213ое077", 4, "",0,
                new Car.Key(true,true));
        cars[2] = new Car("BMW", "Z8", 3.0,
                "черный", 2021, "Германия", "",
                "", "", 4, "",0,
                new Car.Key(true,true));
        cars[3] = new Car("Kia", "Sportage 4-го поколения", 2.4,
                "красный", 2018, "Южная Корея", "",
                "", "", 4, "",0,
                new Car.Key(true,true));
        cars[4] = new Car("Hyundai", "Avante", 1.6,
                "оранжевый", 2016, "Южная Корея", "",
                "", "", 4, "",0,
                new Car.Key(true,true));


    }

    Car.Key key = new Car.Key(true,true);

    //Вывести в консоль данные о каждом автомобиле с перечислением всех их характеристик.
    public void printAllCar() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
