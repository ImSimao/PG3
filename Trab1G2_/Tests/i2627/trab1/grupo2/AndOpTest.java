package i2627.trab1.grupo2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndOpTest {
    @Test
    void calculate() {
        BoolOp andOp1 = new AndOp(new Var("x", true), new Var("y", true));
        BoolOp andOp2 = new AndOp(new Var("x", true), new Var("y", false));
        BoolOp andOp3 = new AndOp(new Var("x", false), new Var("y", true));
        BoolOp andOp4 = new AndOp(new Var("x", false), new Var("y", false));
        assertTrue(andOp1.calculate());
        assertFalse(andOp2.calculate());
        assertFalse(andOp3.calculate());
        assertFalse(andOp4.calculate());
    }

    @Test
    void testToString() {
        BoolOp andOp1 = new AndOp(new Var("x", true), new Var("y", true));
        BoolOp andOp2 = new AndOp(new Var("x", true), new Var("y", false));
        BoolOp andOp3 = new AndOp(new Var("x", false), new Var("y", true));
        BoolOp andOp4 = new AndOp(new Var("x", false), new Var("y", false));
        assertEquals("x & y", andOp1.toString());
        assertEquals("x & y", andOp2.toString());
        assertEquals("x & y", andOp3.toString());
        assertEquals("x & y", andOp4.toString());
    }

    @Test
    void getPriority() {
        BoolOp andOp1 = new AndOp(new Var("x", true), new Var("y", true));
        BoolOp andOp2 = new AndOp(new Var("x", true), new Var("y", false));
        BoolOp andOp3 = new AndOp(new Var("x", false), new Var("y", true));
        BoolOp andOp4 = new AndOp(new Var("x", false), new Var("y", false));
        assertEquals(Priority.MEDIUM, andOp1.getPriority());
        assertEquals(Priority.MEDIUM, andOp2.getPriority());
        assertEquals(Priority.MEDIUM, andOp3.getPriority());
        assertEquals(Priority.MEDIUM, andOp4.getPriority());
    }

}