package kz.itstep.rickandmortyproj.client;



import lombok.Data;
import lombok.Getter;

@Data
public class CharacterResponse {


        private Location location;
    private String name;
    private String species;
    private String gender;


    @Data
    public static class Location{
        private String name;
        private  String url;
    }
}

