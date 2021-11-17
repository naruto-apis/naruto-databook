package com.narutoapis.databook.service;

import com.narutoapis.databook.model.Databook;
import com.narutoapis.databook.model.Character;
import com.narutoapis.databook.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Optional<Character> findById(String name) {
        return characterRepository.findById(name);
    }

    public List<Character> findAll(double databookversion) {

        List<Character> characters = characterRepository.findAll();

        characters.forEach( character -> filterByDatabookVersion(character, databookversion));

        return characters;

    }

    public Optional<Character> findByIdRegex(String name) {
        return characterRepository.findByNameRegex(name);
    }

    public Character findByName(String name, Double databookversion, boolean ignorecase){

        Optional<Character> character = ignorecase ? findByIdRegex(name) : findById(name);

        return character.map(value -> filterByDatabookVersion(value, databookversion)).orElse(null);

    }

    public Character insertNewCharacter(Character character){

        if(findById(character.getName()).isPresent())
            return null;

        characterRepository.insert(character);
        return character;
    }

    public Character updateCharacter(Character character){
        return characterRepository.save(character);
    }

    private Character filterByDatabookVersion(Character character, double databookversion){

        if(databookversion != 0){

            List<Databook> databooks = character
                    .getDatabooks()
                    .stream()
                    .filter(databook -> databook.getVersion() == databookversion)
                    .collect(Collectors.toList());;

            character.setDatabooks(databooks);

        }

        return character;
    }

}
