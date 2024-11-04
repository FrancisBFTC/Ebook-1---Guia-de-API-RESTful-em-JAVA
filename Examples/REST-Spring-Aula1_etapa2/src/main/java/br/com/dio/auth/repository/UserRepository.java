package br.com.dio.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
