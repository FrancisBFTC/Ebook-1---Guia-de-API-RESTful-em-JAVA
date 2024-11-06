package org.hallogame.service;

import java.util.List;

import org.hallogame.model.Character;
import org.hallogame.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
	@Autowired
	private CharacterRepository repository;

	public Character salvar(Character character) {
		return repository.save(character);
	}

	public Character buscar(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Character> buscarTudo() {
		return repository.findAll();
	}

    public void deletar(Long id){
        repository.deleteById(id);
    }
    
}
