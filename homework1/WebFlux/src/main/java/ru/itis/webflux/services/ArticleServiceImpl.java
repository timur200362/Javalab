package ru.itis.webflux.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.webflux.clients.Client;
import ru.itis.webflux.entities.Article;

import java.util.List;

@Component
@AllArgsConstructor
public class ArticleServiceImpl implements Service {

    private final List<Client> clients;

    @Override
    public Flux<Article> getArticles() {
        List<Flux<Article>> fluxes = clients.stream().map(this::getArticles).toList();
        return Flux.merge((fluxes));
    }

    private Flux<Article> getArticles(Client client) {
        return client.getArticles()
                .subscribeOn(Schedulers.boundedElastic());
    }

}
