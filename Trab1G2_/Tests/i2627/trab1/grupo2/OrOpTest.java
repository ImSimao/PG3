package i2627.trab1.grupo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrOpTest {
    @Test
    void calculate() {
        BoolOp orOp1 = new OrOp(new Var("x", true), new Var("y", true));
        BoolOp orOp2 = new OrOp(new Var("x", true), new Var("y", false));
        BoolOp orOp3 = new OrOp(new Var("x", false), new Var("y", true));
        BoolOp orOp4 = new OrOp(new Var("x", false), new Var("y", false));
        assertTrue(orOp1.calculate());
        assertTrue(orOp2.calculate());
        assertTrue(orOp3.calculate());
        assertFalse(orOp4.calculate());
    }

    @Test
    void testToString() {
        BoolOp orOp1 = new OrOp(new Var("x", true), new Var("y", true));
        BoolOp orOp2 = new OrOp(new Var("x", true), new Var("y", false));
        BoolOp orOp3 = new OrOp(new Var("x", false), new Var("y", true));
        BoolOp orOp4 = new OrOp(new Var("x", false), new Var("y", false));
        assertEquals("x | y", orOp1.toString());
        assertEquals("x | y", orOp2.toString());
        assertEquals("x | y", orOp3.toString());
        assertEquals("x | y", orOp4.toString());
    }

    @Test
    void getPriority() {
        BoolOp orOp1 = new OrOp(new Var("x", true), new Var("y", true));
        BoolOp orOp2 = new OrOp(new Var("x", true), new Var("y", false));
        BoolOp orOp3 = new OrOp(new Var("x", false), new Var("y", true));
        BoolOp orOp4 = new OrOp(new Var("x", false), new Var("y", false));
        assertEquals(Priority.LOW, orOp1.getPriority());
        assertEquals(Priority.LOW, orOp2.getPriority());
        assertEquals(Priority.LOW, orOp3.getPriority());
        assertEquals(Priority.LOW, orOp4.getPriority());
    }
}