package ru.netology.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
    @Test
    void shouldReturn10IfAmountIs2000() {
        BonusService service = new BonusService();
        int amount = 2000;

        int actual = service.calculateBonus(amount);
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroIfAmountLowerThan1000() {
        BonusService service = new BonusService();
        int amount = 900;

        int actual = service.calculateBonus(amount);
        int expected = 0;

        assertEquals(expected, actual);
    }
}