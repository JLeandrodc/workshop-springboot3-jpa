package com.joseleandro.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseleandro.demo.entities.Category;
import com.joseleandro.demo.entities.Product;

// Esta interface é responsável por definir as operações de acesso aos dados para a entidade User
// Ela estende a interface JpaRepository, que é uma interface genérica fornecida pelo Spring Data JPA
// Resumindo, permite realizar o CRUD

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
