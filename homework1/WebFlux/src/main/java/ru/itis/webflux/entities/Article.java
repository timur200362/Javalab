package ru.itis.webflux.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Article {
    private String title;
    private String author;
    private String description;
}