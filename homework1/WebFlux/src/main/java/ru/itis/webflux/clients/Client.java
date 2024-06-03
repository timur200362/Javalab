package ru.itis.webflux.clients;

import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Article;

public interface Client {
    Flux<Article> getArticles();
}
