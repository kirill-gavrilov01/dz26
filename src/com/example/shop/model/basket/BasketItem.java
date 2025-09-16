package com.example.shop.model.basket;

public class BasketItem {
    private final com.example.shop.model.basket.Product product;
    private final int quantity;

    /**
     * Основной конструктор для инициализации нового элемента корзины.
     *
     * @param product Товар, добавляемый в корзину.
     * @param quantity Количество единиц товара.
     */
    public BasketItem(com.example.shop.model.basket.Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Получение текущего продукта в элементе корзины.
     *
     * @return Объект Product, соответствующий товару.
     */
    public com.example.shop.model.basket.Product getProduct() {
        return product;
    }

    /**
     * Получение количества товара в данном элементе корзины.
     *
     * @return Количество товара.
     */
    public int getQuantity() {
        return quantity;
    }

    private class Product {
    }
}
