package i2627.trab1.grupo3;

public class SubLeased extends RentalVehicle {

    final RentalVehicle vehicle;
    private final double leasedPrice;

    public SubLeased(RentalVehicle vehicle, double leasedPrice) {
        super("SUBLEASED");
        this.vehicle = vehicle;
        this.leasedPrice = leasedPrice;
    }

    @Override
    public double calculateRent(long km) {
        return vehicle.calculateRent(km) + leasedPrice;
    }
}
