package ru.itis.articles.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Article {
    private String title;
    private String author;
    private String description;
}