package i2627.trab1.grupo3;

public class Car extends RentalVehicle {

    public static final double BASE_RATE = 0.5;
    public static final double BABY_SEAT_FEE = 5.0;

    private final int seatsNumber;
    private final boolean babySeat;

    public Car(int seats, boolean babySeat) {
        this("CAR", seats, babySeat);
    }

    protected Car(String id, int seats, boolean babySeat) {
        super(id + "_CAR");
        this.seatsNumber = seats;
        this.babySeat = babySeat;
    }

    public final int getSeatsNumber() {
        return seatsNumber;
    }

    public final boolean hasBabySeat() {
        return babySeat;
    }

    @Override
    public double calculateRent(long km) {
        double rent = BASE_RATE * km;
        if (babySeat) {
            rent += BABY_SEAT_FEE;
        }
        return rent;
    }

}
