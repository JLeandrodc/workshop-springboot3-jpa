package com.joseleandro.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseleandro.demo.entities.User;

// Esta interface é responsável por definir as operações de acesso aos dados para a entidade User
// Ela estende a interface JpaRepository, que é uma interface genérica fornecida pelo Spring Data JPA
// Resumindo, permite realizar o CRUD
public interface UserRepository extends JpaRepository<User, Long> {
	
}
