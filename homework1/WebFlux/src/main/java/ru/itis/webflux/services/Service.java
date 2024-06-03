package ru.itis.webflux.services;

import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Article;

public interface Service {
    Flux<Article> getArticles();
}
