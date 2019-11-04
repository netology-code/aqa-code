package ru.netology.state.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.state.exception.ItemNotFoundException;
import ru.netology.state.model.PurchaseItem;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartServiceTestNonEmpty {
    private CartService cartService;
    private PurchaseItem first;
    private PurchaseItem second;
    private PurchaseItem third;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        first = new PurchaseItem(1, 0, 0);
        second = new PurchaseItem(2, 0, 0);
        third = new PurchaseItem(3, 0, 0);

        cartService.add(first);
        cartService.add(second);
        cartService.add(third);
    }

    @Test
    void shouldRemoveIfExists() {
        cartService.removeById(first.getItemId());

        List<PurchaseItem> actual = cartService.getList();
        List<PurchaseItem> expected = Arrays.asList(third, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIfRemoveNotExists() {
        int idToRemove = 4;
        assertThrows(ItemNotFoundException.class, () -> cartService.removeById(idToRemove));
    }
}