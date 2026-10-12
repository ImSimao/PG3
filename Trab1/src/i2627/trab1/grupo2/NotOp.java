package i2627.trab1.grupo2;

public final class NotOp extends BoolOp {

    private final Exp exp;

    public NotOp(Exp exp) {
        super('!', Priority.HIGH);
        this.exp = exp;
    }

    @Override
    public boolean calculate() {
        return !exp.calculate();
    }

    @Override
    public String toString() {
        if (exp.getPriority().getValue() < getPriority().getValue()) { // Se a Op tiver prio inferior a "!"
            return symbol + "(" + exp + ")";    //adiciona parenteses ao Original
        }
        return symbol + "" + exp;
    }

}
