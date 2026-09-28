package i2627.trab1.grupo2;

public final class Var implements Exp {
    private final String name;
    private boolean value;

    public Var(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public boolean getValue() {
        return value;
    }
    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean calculate() {
        return value;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public Priority getPriority() {
        return Priority.HIGH;
    }
}
