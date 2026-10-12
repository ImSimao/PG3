package i2627.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricTest {

    @Test
    void addKilometers() {
        Car car = new Electric(5, true, 100);
        car.addKilometers(100);
        assertEquals(100, car.getKilometers());
        car.addKilometers(50);
        assertEquals(150, car.getKilometers());
        assertThrows(IllegalArgumentException.class, () -> car.addKilometers(-10));
    }

    @Test
    void getBatteryLevel() {
        Electric electricCar = new Electric(5, true, 100);
        assertEquals(100, electricCar.getBatteryLevel());
        electricCar.addKilometers(200); // This should reduce battery level by 20%
        assertEquals(80, electricCar.getBatteryLevel());
        electricCar.addKilometers(900); // This should reduce battery level by 90%, but it should not go below 0
        assertEquals(0, electricCar.getBatteryLevel());
    }

    @Test
    void setBatteryLevel() {
        Electric electricCar = new Electric(5, true, 100);
        electricCar.setBatteryLevel(80);
        assertEquals(80, electricCar.getBatteryLevel());
        assertThrows(IllegalArgumentException.class, () -> electricCar.setBatteryLevel(-10));
        assertThrows(IllegalArgumentException.class, () -> electricCar.setBatteryLevel(110));
    }

    @Test
    void calculateRent() {
        Electric car1 = new Electric(5, true, 100);
        assertEquals(Car.BABY_SEAT_FEE + Car.BASE_RATE * 100, car1.calculateRent(100));
        Electric car2 = new Electric(2, false, 100);
        assertEquals(Car.BASE_RATE * 50 , car2.calculateRent(50));
        Electric car3 = new Electric(2, false, Electric.BATTERY_LOW_LEVEL-1);
        assertEquals(Car.BASE_RATE * 50 + Electric.BATTERY_LOW_FEE, car3.calculateRent(50));
        Electric car4 = new Electric(2, false, Electric.BATTERY_LOW_LEVEL);
        assertEquals(Car.BASE_RATE * 50, car4.calculateRent(50));
    }

    @Test
    void getKilometers() {
        Car car = new Electric(5, true, 100);
        assertEquals(0, car.getKilometers());
        car.addKilometers(100);
        assertEquals(100, car.getKilometers());
        car.addKilometers(50);
        assertEquals(150, car.getKilometers());
    }

    @Test
    void compareTo() {
        Car car1 = new Electric(5, true, 100);
        Car car2 = new Electric(2, false, 100);
        car1.addKilometers(100);
        car2.addKilometers(50);
        assertTrue(car1.compareTo(car2) > 0); // car1 has more kilometers than car2
        assertTrue(car2.compareTo(car1) < 0); // car2 has fewer kilometers than car1
        car2.addKilometers(50);
        assertEquals(0, car1.compareTo(car2)); // both have the same kilometers
    }

    @Test
    void getSeatsNumber() {
        Car car = new Electric(5, true, 100);
        assertEquals(5, car.getSeatsNumber());
    }

    @Test
    void hasBabySeat() {
        Car car1 = new Electric(5, true, 100);
        assertTrue(car1.hasBabySeat());
        Car car2 = new Electric(2, false, 100);
        assertFalse(car2.hasBabySeat());
    }

    @Test
    void testRegistrationId() {
        Car car1 = new Electric(5, true, 100);
        Car car2 = new Electric(2, false, 100);
        int serialNumber1 = Integer.parseInt(car1.regId.split("_")[2]);
        int serialNumber2 = Integer.parseInt(car2.regId.split("_")[2]);
        assertEquals(serialNumber1 + 1, serialNumber2); // car2 should have a serial number one greater than car1
    }

}