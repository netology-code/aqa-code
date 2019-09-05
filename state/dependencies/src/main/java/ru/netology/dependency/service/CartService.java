package ru.netology.dependency.service;

import ru.netology.dependency.exception.ItemNotFoundException;
import ru.netology.dependency.model.PurchaseItem;
import ru.netology.dependency.repository.CartRepository;

import java.util.*;

public class CartService {
    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        Optional<PurchaseItem> optional = repository.findById(item.getItemId());
        if (optional.isPresent()) {
            PurchaseItem saved = optional.get();
            saved.setCount(saved.getCount() + item.getCount());
            repository.save(saved);
            return;
        }

        repository.save(item);
    }

    public void removeById(int itemId) {
        int removed = repository.removeById(itemId);
        if (removed == 0) {
            throw new ItemNotFoundException("Item not found: " + itemId);
        }
    }

    public void changeCount(int itemId, int count) {
        PurchaseItem saved = repository.findById(itemId).orElseThrow(ItemNotFoundException::new);
        saved.setCount(count);
        repository.save(saved);
    }

    public List<PurchaseItem> getList() {
        List<PurchaseItem> result = new LinkedList<>(repository.findAll());
        Collections.reverse(result);
        return result;
    }
}
