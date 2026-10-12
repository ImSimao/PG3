package i2627.trab1.grupo3;

public class CommercialVan {

    public static final double BASE_RATE = 0.8;
    public static final double LOAD_FEE_PER_KG = 0.05;

    private final int maxLoad;


    public CommercialVan(int maxLoad) {
        super("VAN");
        this.maxLoad = maxLoad;
    }


    public final int getMaxLoad() {
        return maxLoad;
    }

    @Override
    public double calculateRent(long km) {
        return BASE_RATE * km + LOAD_FEE_PER_KG * maxLoad;
    }


}
