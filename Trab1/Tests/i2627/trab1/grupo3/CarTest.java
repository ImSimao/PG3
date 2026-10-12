package i2627.trab1.grupo3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getSeatsNumber() {
        Car car1 = new Car(5, true);
        assertEquals(5, car1.getSeatsNumber());
        Car car2 = new Car(2, false);
        assertEquals(2, car2.getSeatsNumber());
    }

    @Test
    void hasBabySeat() {
        Car car1 = new Car(5, true);
        assertTrue(car1.hasBabySeat());
        Car car2 = new Car(2, false);
        assertFalse(car2.hasBabySeat());
    }

    @Test
    void calculateRent() {
        Car car1 = new Car(5, true);
        assertEquals(Car.BABY_SEAT_FEE + Car.BASE_RATE * 100, car1.calculateRent(100));
        Car car2 = new Car(2, false);
        assertEquals(Car.BASE_RATE * 50, car2.calculateRent(50));
    }

    @Test
    void getKilometers() {
        Car car = new Car(5, true);
        assertEquals(0, car.getKilometers());
        car.addKilometers(100);
        assertEquals(100, car.getKilometers());
        car.addKilometers(50);
        assertEquals(150, car.getKilometers());
    }

    @Test
    void addKilometers() {
        Car car = new Car(5, true);
        car.addKilometers(100);
        assertEquals(100, car.getKilometers());
        car.addKilometers(50);
        assertEquals(150, car.getKilometers());
        assertThrows(IllegalArgumentException.class, () -> car.addKilometers(-10));
    }

    @Test
    void compareTo() {
        Car car1 = new Car(5, true);
        Car car2 = new Car(2, false);
        car1.addKilometers(100);
        car2.addKilometers(50);
        assertTrue(car1.compareTo(car2) > 0); // car1 has more kilometers than car2
        assertTrue(car2.compareTo(car1) < 0); // car2 has fewer kilometers than car1
        car2.addKilometers(50);
        assertEquals(0, car1.compareTo(car2)); // both have the same kilometers
    }

    @Test
    void testRegistrationId() {
        Car car1 = new Car(5, true);
        Car car2 = new Car(2, false);
        int serialNumber1 = Integer.parseInt(car1.regId.split("_")[1]);
        int serialNumber2 = Integer.parseInt(car2.regId.split("_")[1]);
        assertEquals(serialNumber1 + 1, serialNumber2); // car2 should have a serial number one greater than car1
    }
}