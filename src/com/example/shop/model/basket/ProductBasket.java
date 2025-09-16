package com.example.shop.model.basket;
import java.util.*;

// Аннотация SessionScope привязывает экземпляр корзины к конкретной HTTP-сессии
@Component
@SessionScope
public class ProductBasket {

    // Используем неизменяемую карту для защиты от случайных модификаций
    private final Map<UUID, Integer> products = new HashMap<>();

    /**
     * Метод добавляет товар в корзину.
     *
     * @param productId Идентификатор добавляемого товара
     */
    public void addProduct(UUID productId) {
        // Если товар уже есть в корзине, увеличиваем его количество
        products.merge(productId, 1, Integer::sum);
    }

    /**
     * Возвращает защищённую копию коллекции товаров из корзины.
     *
     * @return Карта товаров в корзине
     */
    public Map<UUID, Integer> getAllProducts() {
        // Возвращаем коллекцию, доступную только для чтения
        return Collections.unmodifiableMap(products);
    }
}
