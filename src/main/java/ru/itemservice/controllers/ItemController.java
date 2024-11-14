package ru.itemservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itemservice.dtos.AddItemRequest;
import ru.itemservice.dtos.AddItemResponse;
import ru.itemservice.services.interfaces.IItemService;

@CrossOrigin()
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/items")
public class ItemController {

    private final IItemService itemService;

    @PostMapping()
    @Operation(
            summary = "Create a new order",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required params for creating an item",
                    content = @Content(
                            schema = @Schema(implementation = AddItemRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Item successfully created",
                            content = @Content(
                                    schema = @Schema(implementation = AddItemResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error"
                    )
            }
    )
    public ResponseEntity<AddItemResponse> createItem(@RequestBody @Valid AddItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.addItem(request));
    }

}

