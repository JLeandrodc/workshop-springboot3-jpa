package com.joseleandro.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joseleandro.demo.entities.Order;
import com.joseleandro.demo.entities.User;
import com.joseleandro.demo.entities.enums.OrderStatus;
import com.joseleandro.demo.repositories.OrderRepository;
import com.joseleandro.demo.repositories.UserRepository;

//Por enquanto, isso vai servir de data base seeding
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired // Serve para injetar automaticamente uma instância de OrderRepository nessa variável orderRepository sempre que essa classe for criada
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// Objetos a serem enviado para o banco h2 (Id nulo pq o banco de dados gera automaticamente
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); //id, instant(parametro) , associação
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT , u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT , u1); 

		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
