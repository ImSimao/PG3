package i2627.trab1.grupo2;

abstract class BinaryOp extends BoolOp {

    private final Exp left;
    private final Exp right;

    public BinaryOp(char symbol, Priority priority, Exp left, Exp right) {
        super(symbol, priority);
        this.left = left;
        this.right = right;
    }

    public final Exp getLeft(){
        return left;
    }
    public final Exp getRight(){
        return right;
    }

    @Override
    public final String toString() {
        return operandToString(left) + " " + symbol + " " +operandToString(right);
    }

    private String operandToString(Exp operand){
        if (operand.getPriority().getValue() < getPriority().getValue()) {
            return "(" + operand + ")";
        }
        return operand.toString();
    }



}
