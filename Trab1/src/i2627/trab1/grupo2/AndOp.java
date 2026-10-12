package i2627.trab1.grupo2;

public final class AndOp extends BinaryOp {

    public AndOp(Exp left, Exp right) {
        super('&', Priority.MEDIUM, left, right);
    }

    @Override
    public boolean calculate(){
        return getLeft().calculate() && getRight().calculate();
    }

}
