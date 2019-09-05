package ru.netology.state.model;

import java.util.Objects;

public class PurchaseItem {
    private int itemId;
    private int itemPrice;
    private int count;

    public PurchaseItem() {
    }

    public PurchaseItem(int itemId, int itemPrice, int count) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItem that = (PurchaseItem) o;
        return itemId == that.itemId &&
                itemPrice == that.itemPrice &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemPrice, count);
    }
}
