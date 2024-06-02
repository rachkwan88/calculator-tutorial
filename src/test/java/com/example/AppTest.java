package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        Calculator c = new Calculator();

        // positive test cases
        assertTrue(c.calc("1+1") == 2);
        assertTrue(c.calc("1+1") == 2);
        assertTrue(c.calc("12*10") == 120);
        assertTrue(c.calc("22-10") == 12);
        assertTrue(c.calc("10+300") == 310);
        assertTrue(c.calc("0*5") == 0);
        assertTrue(c.calc("3/2") == 1.5);
        assertTrue(c.calc("000*000") == 0);
        assertTrue(c.calc("00000001/1") == 1);
        assertTrue(c.calc("0+588583882") == 588583882);

        // negative test cases
        try {
            c.calc("00000001");
            assertTrue("Should catch missing op", false);
        } catch (Exception e) {
            assertTrue("should be here", true);
        }

    }
}
