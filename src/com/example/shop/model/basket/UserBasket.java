package com.example.shop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final int totalAmount;

    public UserBasket(List<BasketItem> items, int totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public List<BasketItem> getItems() { return items; }
    public int getTotalAmount() { return totalAmount; }
    }