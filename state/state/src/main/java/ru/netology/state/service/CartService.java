package ru.netology.state.service;

import ru.netology.state.exception.ItemNotFoundException;
import ru.netology.state.model.PurchaseItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CartService {
    private final List<PurchaseItem> items = new ArrayList<>();

    public void add(PurchaseItem item) {
        for (PurchaseItem o : items) {
            if (o.getItemId() == item.getItemId()) {
                o.setCount(o.getCount() + item.getCount());
                return;
            }
        }

        items.add(item);
    }

    public void removeById(int itemId) {
        if (!items.removeIf(o -> o.getItemId() == itemId)) {
            throw new ItemNotFoundException("Item not found: " + itemId);
        }
    }

    public void changeCount(int itemId, int count) {
        for (PurchaseItem o : items) {
            if (o.getItemId() == itemId) {
                o.setCount(count);
                return;
            }
        }
        throw new ItemNotFoundException("Item not found: " + itemId);
    }

    public List<PurchaseItem> getList() {
        List<PurchaseItem> result = new LinkedList<>(items);
        Collections.reverse(result);
        return result;
    }
}
