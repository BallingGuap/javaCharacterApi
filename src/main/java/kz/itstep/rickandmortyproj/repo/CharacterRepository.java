package kz.itstep.rickandmortyproj.repo;
import kz.itstep.rickandmortyproj.model.Character;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Component
public interface CharacterRepository extends JpaRepository<Character, Long> {
}


