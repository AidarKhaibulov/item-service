package ru.itemservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("items")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private String id;

    private String name;

    private double price;

}
