package ru.itemservice.services.interfaces;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import ru.itemservice.dtos.AddItemRequest;
import ru.itemservice.dtos.AddItemResponse;

@Validated
public interface IItemService {

    AddItemResponse addItem(@Valid AddItemRequest addItemRequest);

}
