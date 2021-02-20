package ru.netology.unit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class BonusServiceTest {
    @Test
    void shouldCalculateBonus() {
        BonusService service = new BonusService();
        int amount = 2000;

        int actual = service.calculateBonus(amount);
        int expected = 10;

        assertEquals(expected, actual);
    }
}
