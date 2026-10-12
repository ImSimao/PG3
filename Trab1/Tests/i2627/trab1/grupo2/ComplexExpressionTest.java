package i2627.trab1.grupo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class ComplexExpressionTest {
    @Test
    void complexExpression() {
        Var a = new Var("A", false);
        Var b = new Var("B", false);
        Var c = new Var("C", false);

        Exp left  = new OrOp(a, new AndOp(b, c));
        Exp right = new OrOp(new AndOp(new NotOp(a), b), new NotOp(c));
        Exp expr  = new NotOp(new AndOp(left, right));

        assertEquals("!((A | B & C) & (!A & B | !C))", expr.toString());

        record UnitTest(boolean A, boolean B, boolean C, boolean R) {}

        UnitTest[] unitTests = {
                new UnitTest(false, false, false, true),
                new UnitTest(false, false, true,  true),
                new UnitTest(false, true,  false, true),
                new UnitTest(false, true,  true,  false),
                new UnitTest(true,  false, false, false),
                new UnitTest(true,  false, true,  true),
                new UnitTest(true,  true,  false, false),
                new UnitTest(true,  true,  true,  true),
        };

        for (UnitTest t : unitTests) {
            a.setValue(t.A());
            b.setValue(t.B());
            c.setValue(t.C());
            assertEquals(t.R(), expr.calculate(),
                    () -> "Falhou para A=" + t.A() + " B=" + t.B() + " C=" + t.C());
        }
    }
}
