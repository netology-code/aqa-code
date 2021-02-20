package ru.netology.unit;


import org.junit.Test;

import static org.junit.Assert.*;

public class BonusServiceTest {
    @Test
    public void shouldCalculateBonus() {
        BonusService service = new BonusService();
        int amount = 2000;

        int actual = service.calculateBonus(amount);
        int expected = 10;

        assertEquals(expected, actual);
    }
}
