package i2627.trab1.grupo3;

public class Electric extends Car {

    public static final int BATTERY_LOW_LEVEL = 20;
    public static final double BATTERY_LOW_FEE = 10.0;

    private int batteryLevel;

    public Electric(int seats, boolean babySeat, int batLevel) {
        super("ELECTRIC", seats, babySeat);
        this.batteryLevel = batLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batLevel) {
        if (batLevel < 0 || batLevel > 100) {
            throw new IllegalArgumentException("Battery level must be between 0 and 100");
        }
        this.batteryLevel = batLevel;
    }

    @Override
    public void addKilometers(long km) {
        super.addKilometers(km);
        int drain = (int) (km / 10);
        batteryLevel = Math.max(0, batteryLevel - drain);
    }

    @Override
    public double calculateRent(long km) {
        double rent = super.calculateRent(km);
        if (batteryLevel < BATTERY_LOW_LEVEL) {
            rent += BATTERY_LOW_FEE;
        }
        return rent;
    }
}
