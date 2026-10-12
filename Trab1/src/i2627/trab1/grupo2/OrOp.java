package i2627.trab1.grupo2;

public final class OrOp extends BinaryOp {

    public OrOp(Exp left, Exp right) {
        super('|', Priority.LOW, left, right);
    }

    @Override
    public boolean calculate(){
        return getLeft().calculate() || getRight().calculate();
    }
}
