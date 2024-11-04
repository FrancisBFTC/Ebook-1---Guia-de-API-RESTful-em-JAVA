package br.com.dio.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.auth.repository.RoleRepository;
import br.com.dio.auth.entity.Role;
@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public Role save(Role role) {
		return repository.save(role);
	}
	
	public Role findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Role> findAll(){
		return repository.findAll();
	}
}
