package ru.itis.webflux.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Article;

import java.util.Arrays;

@Component
public class ArticleClientImpl implements Client {
    private final WebClient client;

    public ArticleClientImpl(@Value("${article.api.url}") String url) {
        client = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    @Override
    public Flux<Article> getArticles(){
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Article[].class))
                .flatMapIterable(Arrays::asList);
    }
}

