package ru.netology.annotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
//    @Test
//    @DisplayName("Should return 10 if amount is 2000")
//    void shouldReturn10IfAmountIs2000() {
//        BonusService service = new BonusService();
//        int amount = 2000;
//
//        int actual = service.calculateBonus(amount);
//        int expected = 10;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Should return zero if amount lower than 1000")
//    void shouldReturnZeroIfAmountLowerThan1000() {
//        BonusService service = new BonusService();
//        int amount = 900;
//
//        int actual = service.calculateBonus(amount);
//        int expected = 0;
//
//        assertEquals(expected, actual);
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "/BonusData.csv", numLinesToSkip = 1)
    void shouldCalculateBonus(int amount, int expected) {
        BonusService service = new BonusService();

        int actual = service.calculateBonus(amount);

        assertEquals(expected, actual);
    }
}