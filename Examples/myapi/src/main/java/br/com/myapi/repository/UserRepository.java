package br.com.myapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
