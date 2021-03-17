package fr.eclixal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKairos {

    @Test
    void testAdd() {
        Kairos kairos = new Kairos();
        assertEquals(3, kairos.add(1,2));
    }

}

