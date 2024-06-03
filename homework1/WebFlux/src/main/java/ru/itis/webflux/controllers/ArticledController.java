package ru.itis.webflux.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Article;
import ru.itis.webflux.services.Service;

@AllArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticledController {
    private final Service service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Article> getArticles() {
        return service.getArticles();
    }

}
