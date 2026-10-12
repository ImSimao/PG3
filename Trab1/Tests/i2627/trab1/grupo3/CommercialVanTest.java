package i2627.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommercialVanTest {

    @Test
    void getMaxLoad() {
        CommercialVan van = new CommercialVan(1000);
        assertEquals(1000, van.getMaxLoad());
    }

    @Test
    void calculateRent() {
        CommercialVan van = new CommercialVan(1000);
        assertEquals(CommercialVan.BASE_RATE * 100 + CommercialVan.LOAD_FEE_PER_KG * 1000, van.calculateRent(100));
    }

    @Test
    void getKilometers() {
        CommercialVan van = new CommercialVan(1000);
        assertEquals(0, van.getKilometers());
        van.addKilometers(100);
        assertEquals(100, van.getKilometers());
        van.addKilometers(50);
        assertEquals(150, van.getKilometers());
    }

    @Test
    void addKilometers() {
        CommercialVan van = new CommercialVan(1000);
        van.addKilometers(100);
        assertEquals(100, van.getKilometers());
        van.addKilometers(50);
        assertEquals(150, van.getKilometers());
        assertThrows(IllegalArgumentException.class, () -> van.addKilometers(-10));
    }

    @Test
    void compareTo() {
        CommercialVan van1 = new CommercialVan(1000);
        CommercialVan van2 = new CommercialVan(800);
        van1.addKilometers(100);
        van2.addKilometers(50);
        assertTrue(van1.compareTo(van2) > 0); // van1 has more kilometers than van2
        assertTrue(van2.compareTo(van1) < 0); // van2 has fewer kilometers than van1
        van2.addKilometers(50);
        assertEquals(0, van1.compareTo(van2)); // both have the same kilometers
    }

    @Test
    void testRegistrationId() {
        CommercialVan van1 = new CommercialVan(1000);
        CommercialVan van2 = new CommercialVan(800);
        int serialNumber1 = Integer.parseInt(van1.regId.split("_")[1]);
        int serialNumber2 = Integer.parseInt(van2.regId.split("_")[1]);
        assertEquals(serialNumber1 + 1, serialNumber2); // van2 should have a serial number one greater than van1
    }
}