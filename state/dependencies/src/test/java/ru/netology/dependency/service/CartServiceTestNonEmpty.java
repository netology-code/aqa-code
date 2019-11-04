package ru.netology.dependency.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.dependency.exception.ItemNotFoundException;
import ru.netology.dependency.model.PurchaseItem;
import ru.netology.dependency.repository.CartRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTestNonEmpty {
    private CartService cartService;
    @Mock
    private CartRepository cartRepository;
    private PurchaseItem first;
    private PurchaseItem second;
    private PurchaseItem third;


    @BeforeEach
    void setUp() {
        cartService = new CartService(cartRepository);
        first = new PurchaseItem(1, 0, 0);
        second = new PurchaseItem(2, 0, 0);
        third = new PurchaseItem(3, 0, 0);

        cartService.add(first);
        cartService.add(second);
        cartService.add(third);
    }

    @Test
    void shouldRemoveIfExists() {
        List<PurchaseItem> returned = Arrays.asList(second, third);
        doReturn(returned).when(cartRepository).findAll();
        doReturn(1).when(cartRepository).removeById(first.getItemId());

        cartService.removeById(first.getItemId());

        List<PurchaseItem> expected = Arrays.asList(third, second);
        List<PurchaseItem> actual = cartService.getList();

        assertEquals(expected, actual);
        verify(cartRepository).removeById(first.getItemId());
    }

    @Test
    void shouldThrowIfRemoveNotExists() {
        int idToRemove = 4;
        doReturn(0).when(cartRepository).removeById(idToRemove);

        assertThrows(ItemNotFoundException.class, () -> cartService.removeById(idToRemove));
        verify(cartRepository).removeById(idToRemove);
    }
}
