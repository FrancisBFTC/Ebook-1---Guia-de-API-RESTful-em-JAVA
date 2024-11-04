package org.hallogame;

import org.hallogame.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.hallogame.model.Character;

@Component
public class Initialize implements CommandLineRunner{

    @Autowired
    CharacterService service;
    @Autowired
    Character character;

    @Override
    public void run(String... args) throws Exception {
        Character character = new Character();
        character.setName("Benedita");
        character.setSkill("Fazia magia negra");
        character.setWeakness("Água benta");
        character.setStrength(30);
        character.setIntelligence(70);
        character.setDamage(60);
        character.setType("magia");
        service.salvar(character);
    }

}
