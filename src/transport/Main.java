package transport;

import transport.CarAssortment;

public class Main {
    public static void main(String[] args) {

// ООП введение
        System.out.println("HW: ООП введение");
        System.out.println();

// ООП Инкапсуляция
        System.out.println("HW: ООП Инкапсуляция");

        System.out.println("информация о каждом автомобиле и все указанные характеристики:");

        CarAssortment cars = new CarAssortment();
        cars.printAllCar();
        System.out.println();

// ООП: наследование, static
        System.out.println("HW: ООП: наследование, static");

        System.out.println("информация о каждом транспорте и все указанные характеристики:");
        System.out.println();

        cars.printAllCar();
        System.out.println();

        BusAssortment busAssortment = new BusAssortment();
        busAssortment.printAllBas();


    }
}