package i2627.trab1.grupo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionsTest {
    @Test
    void exp1() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        BoolOp andOp1 = new AndOp(x, new NotOp(y));
        BoolOp andOp2 = new AndOp(new NotOp(x), y);
        BoolOp andOp3 = new AndOp(new NotOp(x), new NotOp(y));
        BoolOp andOp4 = new NotOp(new AndOp(x, y));
        assertEquals("x & !y", andOp1.toString());
        assertEquals("!x & y", andOp2.toString());
        assertEquals("!x & !y", andOp3.toString());
        assertEquals("!(x & y)", andOp4.toString());
        assertFalse(andOp1.calculate());
        assertFalse(andOp2.calculate());
        assertFalse(andOp3.calculate());
        assertFalse(andOp4.calculate());
    }
    @Test
    void exp2() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        BoolOp orOp1 = new OrOp(x, new NotOp(y));
        BoolOp orOp2 = new OrOp(new NotOp(x), y);
        BoolOp orOp3 = new OrOp(new NotOp(x), new NotOp(y));
        BoolOp orOp4 = new NotOp(new OrOp(x, y));
        assertEquals("x | !y", orOp1.toString());
        assertEquals("!x | y", orOp2.toString());
        assertEquals("!x | !y", orOp3.toString());
        assertEquals("!(x | y)", orOp4.toString());
        assertTrue(orOp1.calculate());
        assertTrue(orOp2.calculate());
        assertFalse(orOp3.calculate());
        assertFalse(orOp4.calculate());
    }

    @Test
    void exp3() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        BoolOp andOp = new AndOp(x, y);
        BoolOp orOp = new OrOp(x, y);
        BoolOp notAndOp = new NotOp(andOp);
        BoolOp notOrOp = new NotOp(orOp);
        assertEquals("!(x & y)", notAndOp.toString());
        assertEquals("!(x | y)", notOrOp.toString());
        assertFalse(notAndOp.calculate());
        assertFalse(notOrOp.calculate());
    }

    @Test
    void exp4() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        Exp exp = new AndOp(new OrOp(x, y), new NotOp(new OrOp(x, y)));
        assertEquals("(x | y) & !(x | y)", exp.toString());
        assertFalse(exp.calculate());
    }

    @Test
    void exp5() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        Exp z = new Var("z", true);
        Exp exp = new AndOp(x, new AndOp(y, z));
        assertEquals("x & y & z", exp.toString());
        assertTrue(exp.calculate());
    }

    @Test
    void exp6() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        Exp z = new Var("z", true);
        Exp exp = new OrOp(x, new OrOp(y, z));
        assertEquals("x | y | z", exp.toString());
        assertTrue(exp.calculate());
    }
    @Test
    void exp7() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        Exp z = new Var("z", false);
        Exp exp = new OrOp(x, new AndOp(y, z));
        assertEquals("x | y & z", exp.toString());
        assertTrue(exp.calculate());
    }

    @Test
    void exp8() {
        Exp x = new Var("x", true);
        Exp y = new Var("y", true);
        Exp z = new Var("z", false);
        Exp exp = new AndOp(new OrOp(x, y), z);
        assertEquals("(x | y) & z", exp.toString());
        assertFalse(exp.calculate());
    }
}
