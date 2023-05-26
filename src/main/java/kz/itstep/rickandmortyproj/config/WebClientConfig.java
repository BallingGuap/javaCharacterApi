package kz.itstep.rickandmortyproj.config;

import kz.itstep.rickandmortyproj.model.Character;
import kz.itstep.rickandmortyproj.repo.CharacterRepository;
import kz.itstep.rickandmortyproj.service.RickAndMortyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient characterClient(){
        return WebClient.create("https://rickandmortyapi.com/api/");
    }



}
