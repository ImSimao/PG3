package i2627.trab1.grupo3;


// ONGOING, JB

public class Electric extends Car
{
    public final int BATTERY_LOW_LEVEL = 20;
    public final double BATTERY_LOW_FEE= 10.0;
    private int batteryLevel;

    public Electric (int seats, boolean babySeat, int batLevel{
        super("ELECTRIC");
     //   this.batteryLevel= (batLevel + xxxx )
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public IllegalArgumentException setBatteryLevel(int bl){
        if(batteryLevel<0 | batteryLevel>100) {
            throw "Battery level must be between 0 and 100";
        }
    }

    public IllegalArgumentException addKilometers (long km){

    }

    public double calculateRent (long km){

    }

}
