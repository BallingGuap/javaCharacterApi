package kz.itstep.rickandmortyproj.controller;

import kz.itstep.rickandmortyproj.model.Character;
import kz.itstep.rickandmortyproj.service.RickAndMortyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info/character")
public class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;

    private final Character exceptionCharacter ;
    public RickAndMortyController(RickAndMortyService rickAndMortyService) {
        this.exceptionCharacter = new Character(404l, "",
                "Response Character Exception", "Response Character Exception", "Response Character Exception");
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id){
        try {
            var character = rickAndMortyService.getCharacter(id);
            return  ResponseEntity.ok(character);
        }
        catch (Exception e){
            exceptionCharacter.setName(e.getMessage());
            return new ResponseEntity<Character>(exceptionCharacter, HttpStatus.FORBIDDEN);
        }


    }
}
