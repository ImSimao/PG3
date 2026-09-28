package i2627.trab1.grupo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectTest {

    @Test
    void getNoOriginCounter() {
        assertEquals(0, Rect.getNoOriginCounter());
        Rect r1 = new Rect(3, 4);
        assertEquals(1, Rect.getNoOriginCounter());
        Rect r2 = new Rect(5, 6, 7, 8);
        assertEquals(1, Rect.getNoOriginCounter());
    }

    @Test
    void getX() {
        Rect r = new Rect(1, 2, 3, 4);
        assertEquals(1, r.getX());
    }

    @Test
    void getY() {
        Rect r = new Rect(1, 2, 3, 4);
        assertEquals(2, r.getY());
    }

    @Test
    void getW() {
        Rect r = new Rect(1, 2, 3, 4);
        assertEquals(3, r.getW());
    }

    @Test
    void getH() {
        Rect r = new Rect(1, 2, 3, 4);
        assertEquals(4, r.getH());
    }

    @Test
    void testToString() {
        Rect r = new Rect(1, 2, 3, 4);
        assertEquals("(1.0,2.0)->(4.0,6.0)", r.toString());
    }

    @Test
    void testEquals() {
        Rect r1 = new Rect(1, 2, 3, 4);
        Rect r2 = new Rect(1, 2, 3, 4);
        assertTrue(r1.equals(r2));
        Rect r3 = new Rect(1, 2, 3, 5);
        assertFalse(r1.equals(r3));
        Rect r4 = new Rect(1.009, 2.009, 3.009, 4.009);
        assertTrue(r1.equals(r4));
        Rect r5 = new Rect(1.011, 2.009, 3.009, 4.009);
        assertFalse(r1.equals(r5));
        Rect r6 = new Rect(1.009, 2.011, 3.009, 4.009);
        assertFalse(r1.equals(r6));
        Rect r7 = new Rect(1.009, 2.009, 3.011, 4.009);
        assertFalse(r1.equals(r7));
        Rect r8 = new Rect(1.009, 2.009, 3.009, 4.011);
        assertFalse(r1.equals(r8));
    }

    @Test
    void isOverlapped() {
        Rect r1 = new Rect(1, 2, 3, 4);
        Rect fullOverlap = new Rect(1, 2, 3, 4);
        assertTrue(r1.isOverlapped(fullOverlap));
        Rect rightBottomOverlap = new Rect(2, 3, 3, 4);
        assertTrue(r1.isOverlapped(rightBottomOverlap));
        Rect leftBottomOverlap = new Rect(-2, 3, 3, 4);
        assertTrue(r1.isOverlapped(leftBottomOverlap));
        Rect rightTopOverlap = new Rect(2, -2, 3, 4);
        assertTrue(r1.isOverlapped(rightTopOverlap));
        Rect leftTopOverlap = new Rect(-2, -2, 3, 4);
        assertTrue(r1.isOverlapped(leftTopOverlap));

        Rect rightNoOverlap = new Rect(5, 6, 3, 4);
        assertFalse(r1.isOverlapped(rightNoOverlap));
        Rect bottomNoOverlap = new Rect(1, 7, 3, 4);
        assertFalse(r1.isOverlapped(bottomNoOverlap));
        Rect leftNoOverlap = new Rect(-5, 2, 3, 4);
        assertFalse(r1.isOverlapped(leftNoOverlap));
        Rect topNoOverlap = new Rect(1, -3, 3, 4);
        assertFalse(r1.isOverlapped(topNoOverlap));

        Rect edgeTopOverlap = new Rect(1, 6, 3, 4);
        assertTrue(r1.isOverlapped(edgeTopOverlap));
        Rect edgeBottomOverlap = new Rect(1, -2, 3, 4);
        assertTrue(r1.isOverlapped(edgeBottomOverlap));
        Rect edgeLeftOverlap = new Rect(-2, 2, 3, 4);
        assertTrue(r1.isOverlapped(edgeLeftOverlap));
        Rect edgeRightOverlap = new Rect(4, 2, 3, 4);
        assertTrue(r1.isOverlapped(edgeRightOverlap));
    }

    @Test
    void parseRect() {
        Rect r = Rect.parseRect("(1.0,2.0)->(3.0,4.0)");
        assertEquals(1, r.getX());
        assertEquals(2, r.getY());
        assertEquals(2, r.getW());
        assertEquals(2, r.getH());
        assertNull(Rect.parseRect("(1.0,2.0)-(3.0,4.0)"));
        assertNull(Rect.parseRect("(1.0,2.0)>(3.0,4.0)"));
        assertNull(Rect.parseRect("(1.0,2.0)(3.0,4.0)"));
        assertNull(Rect.parseRect("(1.0)->(3.0,4.0)"));
        assertNull(Rect.parseRect("(1.0,2.0)->(3.0)"));
        assertNull(Rect.parseRect("(1.0,2.0,3.0)->(3.0,4.0,5.0)"));
        assertNull(Rect.parseRect("(1.0,2.0)->(3.0,4.0,5.0)"));
        assertNull(Rect.parseRect("(1.0,2.0)->(3.0,4.0)->(5.0,6.0)"));
    }
}