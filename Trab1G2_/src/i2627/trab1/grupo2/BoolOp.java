package i2627.trab1.grupo2;

abstract class BoolOp implements Exp{

    protected final char symbol;
    private final Priority priority;

    protected BoolOp(char symbol, Priority priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }



}
