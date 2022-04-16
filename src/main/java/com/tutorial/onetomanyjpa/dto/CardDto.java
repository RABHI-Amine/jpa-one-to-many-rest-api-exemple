package com.tutorial.onetomanyjpa.dto;

import com.tutorial.onetomanyjpa.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class CardDto {
    private Long id;
    private String name;
    private List<Item> items;
}
