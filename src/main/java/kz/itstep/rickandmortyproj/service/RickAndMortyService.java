package kz.itstep.rickandmortyproj.service;

import com.fasterxml.jackson.databind.JsonNode;
import kz.itstep.rickandmortyproj.client.CharacterResponse;
import kz.itstep.rickandmortyproj.model.Character;
import kz.itstep.rickandmortyproj.repo.CharacterRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RickAndMortyService {
    private final WebClient characterClient;
    private final CharacterRepository characterRepository;


    public Character getCharacter(Long id)
            throws NullPointerException{
        if(id == null){
            throw new NullPointerException("id is null");
        }
        Character character = null;
        var dbCharacter = characterRepository.findById(id);
        if(dbCharacter.isEmpty()){
            character = getCharacterByResponse(id);
            characterRepository.save(character);
        }
        else {
            character =  dbCharacter.get();
        }
        return character;
    }
    public Character getCharacterByResponse(Long id){
        var characterResponse = characterClient
                .get().uri(uriBuilder -> uriBuilder
                        .path("character/" + id.toString())
                        .build())
                .retrieve()
                .bodyToMono(CharacterResponse.class)
                .block();

        return new Character(id,
                characterResponse.getLocation().getName(),
                characterResponse.getName(),
                characterResponse.getSpecies(),
                characterResponse.getGender());
    }
}
