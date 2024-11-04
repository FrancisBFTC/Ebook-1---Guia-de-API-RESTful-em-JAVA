package org.hallogame.controller;

import org.hallogame.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.hallogame.model.Character;

@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    @Autowired
    CharacterService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Character> saveCharacter(@RequestBody @Autowired Character chars){
        chars = service.salvar(chars);
        return ResponseEntity.ok().body(chars);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> searchCharacter(@PathVariable Long id){
        Character character = service.buscar(id);
        return ResponseEntity.ok().body(character);
    }

    @GetMapping(value = "/search-all")
    public ResponseEntity<List<Character>> searchAllCharacter(){
        List<Character> characters = service.buscarTudo();
        return ResponseEntity.ok().body(characters);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id){
        Character character = service.buscar(id);
        service.deletar(id);
        return ResponseEntity.ok().body(
            "O personagem " + character.getName() + " foi excluído com sucesso!"
        );
    }
}
