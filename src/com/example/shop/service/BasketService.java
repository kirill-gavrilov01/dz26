package com.example.shop.service;

import com.example.shop.model.basket.BasketItem;
import com.example.shop.model.basket.UserBasket;
import com.example.shop.model.basket.ProductBasket;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@com.example.shop.service.Service
public class BasketService {

    private final ProductBasket basketComponent;
    private final StorageService storageService;

    @com.example.shop.service.Autowired
    public BasketService(ProductBasket basketComponent, StorageService storageService) {
        this.basketComponent = basketComponent;
        this.storageService = storageService;
    }

    // Метод добавления товара в корзину
    public void addProduct(UUID productId) {
        Optional<com.example.shop.service.Product> product = storageService.getProductById(productId);
        if (!product.isPresent()) {
            throw new IllegalArgumentException("Нет продукта с указанным ID.");
        }
        basketComponent.addProduct(productId); // Добавляем товар в корзину
    }

    // Метод для получения полной корзины пользователя
    public UserBasket getUserBasket() {
        // Получаем все товары из корзины
        Map<UUID, Integer> cartItems = basketComponent.getAllProducts();

        // Преобразовываем map в объекты BasketItem
        List<BasketItem> basketItems = cartItems.entrySet().stream()
                .map(entry -> new BasketItem((com.example.shop.model.basket.Product) storageService.getProductById(entry.getKey()).orElse(null),
                        entry.getValue()))
                .filter(bi -> bi != null && bi.getProduct() != null)
                .collect(Collectors.toList());

        // Рассчитываем итоговую сумму корзины
        int totalAmount;
        totalAmount = basketItems.stream()
                .mapToInt(bi -> bi.getProduct().getPrice() * bi.getQuantity())
                .sum();

        return new UserBasket(basketItems, totalAmount);
    }

    public boolean isValidProduct(UUID productId) {

        return false;
    }
}