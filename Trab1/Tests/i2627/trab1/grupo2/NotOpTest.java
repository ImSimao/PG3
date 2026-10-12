package i2627.trab1.grupo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotOpTest {

    @Test
    void calculate() {
        BoolOp notOp1 = new NotOp(new Var("x", true));
        BoolOp notOp2 = new NotOp(new Var("x", false));
        assertFalse(notOp1.calculate());
        assertTrue(notOp2.calculate());
    }

    @Test
    void testToString() {
        BoolOp notOp1 = new NotOp(new Var("x", true));
        BoolOp notOp2 = new NotOp(new Var("x", false));
        assertEquals("!x", notOp1.toString());
        assertEquals("!x", notOp2.toString());
    }

    @Test
    void getPriority() {
        BoolOp notOp1 = new NotOp(new Var("x", true));
        BoolOp notOp2 = new NotOp(new Var("x", false));
        assertEquals(Priority.HIGH, notOp1.getPriority());
        assertEquals(Priority.HIGH, notOp2.getPriority());
    }
}