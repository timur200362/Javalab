package ru.itis.articles.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.articles.entities.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping()
    public List<Article> getAllArticles() throws InterruptedException {
        Thread.sleep(5000);
        return List.of(
                Article.builder()
                        .title("Отцы и дети")
                        .author("Тургенев И.С.")
                        .description("Роман")
                        .build(),
                Article.builder()
                        .title("Идиот")
                        .author("Достоевский Ф.М.")
                        .description("Произведение")
                        .build(),
                Article.builder()
                        .title("Морфий")
                        .author("Булгаков М.А.")
                        .description("Произведение")
                        .build()
        );
    }
}
