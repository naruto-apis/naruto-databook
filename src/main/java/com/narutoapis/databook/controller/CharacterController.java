package com.narutoapis.databook.controller;

import com.narutoapis.databook.service.CharacterService;
import com.narutoapis.databook.model.Character;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping(value="/api/v1")
@AllArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public List<Character> findAll(@RequestParam(required = false, defaultValue = "0" ) String databookversion){
        return characterService.findAll(Double.parseDouble(databookversion));
    }

    @GetMapping(value="/{name}")
    public Character findByName(
            @PathVariable String name,
            @RequestParam(required = false, defaultValue = "true") String ignorecase,
            @RequestParam(required = false, defaultValue = "0"   ) String databookversion ){
        return characterService.findByName(
                name,
                Double.parseDouble(databookversion),
                Boolean.parseBoolean(ignorecase));
    }

    @PostMapping
    public Character insertCharacter(@RequestBody Character character){
        return characterService.insertNewCharacter(character);
    }

    @PutMapping
    public Character saveCharacter(@RequestBody Character character){
        return characterService.updateCharacter(character);
    }

}
