package com.narutoapis.databook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.narutoapis.databook.model.Character;

import java.util.Optional;

public interface CharacterRepository extends MongoRepository<Character, String> {
    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    Optional<Character>findByNameRegex(String regexString);
}
