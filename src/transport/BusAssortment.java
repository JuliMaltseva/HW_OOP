package transport;

public class BusAssortment {
    private static Bus [] buses = new Bus[3];
    {
        buses[0] = new Bus("ПАЗ", "3205",1999, "Россия", "голубой",110);
        buses[1] = new Bus("Scania-ЛиАЗ", "VOYAGE",2015, "Россия", "",0);
        buses[2] = new Bus("Hyundai", "Universe",2019, "Южная Корея", "серый",142);
    }

    public void printAllBas() {
        for (Bus bus: buses) {
            System.out.println(bus);
        }
    }
}
