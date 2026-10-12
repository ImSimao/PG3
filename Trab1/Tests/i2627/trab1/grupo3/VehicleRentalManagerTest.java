package i2627.trab1.grupo3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRentalManagerTest {

    RentalVehicle[] vehicles = {
            new Car(4, true),
            new Car(5, false),
            new Electric(4, true, 80),
            new CommercialVan(1000),
            new CommercialVan(2000),
            new SubLeased(new CommercialVan(1500), 50.0)
    };

    @Test
    void addAvailableVehicles() {
        VehicleRentalManager manager = new VehicleRentalManager();
        assertDoesNotThrow(() -> manager.addAvailableVehicles(vehicles));
        assertEquals(vehicles.length, manager.availableVehicles.size());
        assertThrows(VehicleException.class, () -> manager.addAvailableVehicles(vehicles[2]));
        assertEquals(0, manager.rentedVehicles.size());
    }

    @Test
    void rentVehicle() {
        VehicleRentalManager manager = new VehicleRentalManager();
        assertDoesNotThrow(() -> manager.addAvailableVehicles(vehicles));
        assertDoesNotThrow(() -> manager.rentVehicle(vehicles[0]));
        assertEquals(1, manager.rentedVehicles.size());
        assertFalse(manager.availableVehicles.contains(vehicles[0]));
        assertThrows(VehicleException.class, () -> manager.rentVehicle(vehicles[0]));
    }

    @Test
    void returnVehicle() {
        VehicleRentalManager manager = new VehicleRentalManager();
        assertDoesNotThrow(() -> manager.addAvailableVehicles(vehicles));
        assertDoesNotThrow(() -> manager.rentVehicle(vehicles[0]));
        double rent = assertDoesNotThrow(() -> manager.returnVehicle(vehicles[0], 300));
        assertEquals(vehicles[0].calculateRent(300), rent); // Assuming the rent calculation is based on the vehicle's calculateRent method
        assertEquals(0, manager.rentedVehicles.size());
        assertTrue(manager.availableVehicles.contains(vehicles[0]));
        assertThrows(VehicleException.class, () -> manager.returnVehicle(vehicles[1], 100)); // Vehicle not rented
    }

    @Test
    void deleteVehicle() {
        VehicleRentalManager manager = new VehicleRentalManager();
        assertDoesNotThrow(() -> manager.addAvailableVehicles(vehicles));
        assertDoesNotThrow(() -> manager.deleteVehicle(vehicles[0]));
        assertFalse(manager.availableVehicles.contains(vehicles[0]));
        assertThrows(VehicleException.class, () -> manager.deleteVehicle(vehicles[0])); // Vehicle already deleted
    }

    @Test
    void getVehicles() {
        List<RentalVehicle> filteredVehicles = VehicleRentalManager.getVehicles(List.of(vehicles), v -> v instanceof Car);
        assertEquals(3, filteredVehicles.size());
        assertTrue(filteredVehicles.containsAll(List.of(vehicles[0], vehicles[1], vehicles[2])));
        filteredVehicles = VehicleRentalManager.getVehicles(List.of(vehicles), v -> v instanceof Electric);
        assertEquals(1, filteredVehicles.size());
        assertTrue(filteredVehicles.contains(vehicles[2]));
        filteredVehicles = VehicleRentalManager.getVehicles(List.of(vehicles), v -> v instanceof CommercialVan);
        assertEquals(2, filteredVehicles.size());
        assertTrue(filteredVehicles.containsAll(List.of(vehicles[3], vehicles[4])));
        filteredVehicles = VehicleRentalManager.getVehicles(List.of(vehicles), v -> v instanceof SubLeased);
        assertEquals(1, filteredVehicles.size());
        assertTrue(filteredVehicles.contains(vehicles[5]));
    }

    @Test
    void getVansAboveLoad() {
        VehicleRentalManager manager = new VehicleRentalManager();
        assertDoesNotThrow(() -> manager.addAvailableVehicles(vehicles));
        RentalVehicle[] above1500Load = manager.getVansAboveLoad(1500);
        assertEquals(1, above1500Load.length);
        assertEquals(vehicles[4], above1500Load[0]);
        RentalVehicle[] above500Load = manager.getVansAboveLoad(500);
        assertEquals(3, above500Load.length);
        assertTrue(List.of(above500Load).containsAll(List.of(vehicles[3], vehicles[4], vehicles[5])));
        RentalVehicle[] above2500Load = manager.getVansAboveLoad(2500);
        assertEquals(0, above2500Load.length);
    }

    @Test
    void getVehiclesAboveKm() {
        // ToDo by students: Implement this test method to verify the getVehiclesAboveKm method functionality
        //  1. Add 100, 200 and 300 kilometers to first three vehicles, in this order, before testing getVehiclesAboveKm
        //  2. Test getVehiclesAboveKm method with 100, 299 and 500 kilometers, and assert the returned vehicles are correct
    }

}