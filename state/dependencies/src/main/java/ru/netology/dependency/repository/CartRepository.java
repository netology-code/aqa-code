package ru.netology.dependency.repository;

import ru.netology.dependency.model.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    List<PurchaseItem> findAll();
    Optional<PurchaseItem> findById(int id);
    void save(PurchaseItem item);
    int removeById(int id);
}
