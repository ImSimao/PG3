package i2627.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubLeasedTest {

    @Test
    void calculateRent() {
        Car car = new Car(5, true);
        SubLeased subLeasedCar = new SubLeased(car, 50);
        assertEquals(50 + Car.BABY_SEAT_FEE + Car.BASE_RATE * 100, subLeasedCar.calculateRent(100));
        Electric electricCar = new Electric(5, true, 100);
        SubLeased subLeasedElectricCar = new SubLeased(electricCar, 50);
        assertEquals(50 + Car.BABY_SEAT_FEE + Car.BASE_RATE * 100, subLeasedElectricCar.calculateRent(100));
        CommercialVan van = new CommercialVan(1000);
        SubLeased subLeasedVan = new SubLeased(van, 50);
        assertEquals(50 + CommercialVan.BASE_RATE * 100 + CommercialVan.LOAD_FEE_PER_KG * 1000, subLeasedVan.calculateRent(100));
    }
}