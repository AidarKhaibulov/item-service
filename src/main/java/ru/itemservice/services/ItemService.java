package ru.itemservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itemservice.dtos.AddItemRequest;
import ru.itemservice.dtos.AddItemResponse;
import ru.itemservice.models.Item;
import ru.itemservice.repositories.ItemRepository;
import ru.itemservice.services.interfaces.IItemService;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final ItemRepository itemRepo;

    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        Item saved = itemRepo.save(Item.builder()
                .price(request.price())
                .name(request.name())
                .build());

        return AddItemResponse.builder()
                .id(saved.getId())
                .build();
    }

}