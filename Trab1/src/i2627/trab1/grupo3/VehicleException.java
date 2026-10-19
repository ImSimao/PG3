package i2627.trab1.grupo3;

public class VehicleException extends Exception {

    private final RentalVehicle vehicle;

    public VehicleException(String message) {
        super(message);
        this.vehicle = null;
    }

    public VehicleException(String message, RentalVehicle vehicle) {
        super(message);
        this.vehicle = vehicle;
    }

    public final RentalVehicle getVehicle() {
        return vehicle;
    }
}
