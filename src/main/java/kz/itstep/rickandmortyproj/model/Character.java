package kz.itstep.rickandmortyproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Character {
    @Id
    private Long id;
    private String locationName;
    private String name;
    private String species;
    private String gender;
}
