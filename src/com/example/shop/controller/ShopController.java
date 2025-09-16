package com.example.shop.controller;

import com.example.shop.model.basket.UserBasket;
import com.example.shop.service.BasketService;

import java.util.UUID;

/**
 * Контроллер для работы с корзиной магазина.
 */
@com.example.shop.controller.RestController
@com.example.shop.controller.RequestMapping("/shop")
public class ShopController {

    private final BasketService basketService;

    /**
     * Конструктор с автоматическим внедрением сервиса корзины.
     *
     * @param basketService Сервис корзины.
     */
    @com.example.shop.controller.Autowired
    public ShopController(BasketService basketService) {
        this.basketService = basketService;
    }

    /**
     * Добавляет продукт в корзину текущего пользователя.
     *
     * @param id Уникальный идентификатор продукта.
     * @return HTTP-ответ 201 (Created), если продукт успешно добавлен в корзину.
     */
    @com.example.shop.controller.PostMapping("/basket/add/{id}")
    public com.example.shop.controller.ResponseEntity<Void> addProduct(@com.example.shop.controller.PathVariable("id") UUID id) {
        try {
            basketService.addProduct(id);
            return ResponseEntity.status(HttpStatus.CREATED); // Сообщаем успешное создание
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest(); // Сообщаем о проблемах с запросом
        }
    }

    /**
     * Получает содержимое корзины текущего пользователя.
     *
     * @return Пользовательская корзина с товарами.
     */
    @com.example.shop.controller.GetMapping("/basket/show")
    private com.example.shop.service.ResponseEntity getUserBasket() {
        UserBasket userBasket = basketService.getUserBasket();
        return ResponseEntity.ok(userBasket);
    }

    private static class ResponseEntity {
        public static com.example.shop.service.ResponseEntity ok(UserBasket userBasket) {

            return null;
        }

        public static com.example.shop.controller.ResponseEntity<Void> badRequest() {

            return null;
        }

        public static com.example.shop.controller.ResponseEntity<Void> status(Object created) {

            return null;
        }
    }
}