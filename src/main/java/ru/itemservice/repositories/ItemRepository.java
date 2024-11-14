package ru.itemservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itemservice.models.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
}
