package i2627.trab1.grupo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VarTest {

    @Test
    void getName() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        assertEquals("x", v1.getName());
        assertEquals("y", v2.getName());
    }

    @Test
    void getValue() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        assertTrue(v1.getValue());
        assertFalse(v2.getValue());
    }

    @Test
    void setValue() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        v1.setValue(false);
        v2.setValue(true);
        assertFalse(v1.getValue());
        assertTrue(v2.getValue());
    }

    @Test
    void calculate() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        assertTrue(v1.calculate());
        assertFalse(v2.calculate());
    }

    @Test
    void testToString() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        assertEquals("x", v1.toString());
        assertEquals("y", v2.toString());
    }

    @Test
    void getPriority() {
        Var v1 = new Var("x", true);
        Var v2 = new Var("y", false);
        assertEquals(Priority.HIGH, v1.getPriority());
        assertEquals(Priority.HIGH, v2.getPriority());
    }
}