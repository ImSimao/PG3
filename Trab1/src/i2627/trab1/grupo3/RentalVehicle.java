package i2627.trab1.grupo3;

public abstract class RentalVehicle implements Comparable<RentalVehicle> {
    protected final String regId;
    private long kilometers;
    private static int serialNumberCounter = 1;


    protected RentalVehicle(String id) {
        this.regId = id + "_" + serialNumberCounter;
        serialNumberCounter++;
        this.kilometers = 0;
    }

    public final long getKilometers() {
        return kilometers;
    }

    public void addKilometers(long kilometers) {
        if (kilometers < 0 )
            throw new IllegalArgumentException("Kilometers cannot be negative");
        this.kilometers += kilometers;
    }

    public abstract double calculateRent(long km);


    @Override
    public int compareTo(RentalVehicle other) {
        return Long.compare(this.kilometers, other.kilometers);
    }




}
