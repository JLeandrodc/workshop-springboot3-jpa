//SERVICE LAYER (RESOURCER -->SERVICE LAYER(AQUI) --> REPOSITORY

package com.joseleandro.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleandro.demo.entities.User;
import com.joseleandro.demo.repositories.UserRepository;

// Esta classe representa um serviço responsável por operações relacionadas aos usuários
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // Repositório de dados para acesso aos usuários
	
	// Método para encontrar todos os usuários
	public List<User> findAll(){
		return repository.findAll(); // Retorna todos os usuários armazenados no banco de dados
	}
	
	public User findById(Long id) {
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}
}

