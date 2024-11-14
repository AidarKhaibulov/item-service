package ru.itemservice.dtos;

import jakarta.validation.constraints.NotNull;

public record AddItemRequest(@NotNull String name,@NotNull Double price) {

}