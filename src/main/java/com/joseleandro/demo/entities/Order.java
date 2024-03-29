package com.joseleandro.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joseleandro.demo.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Diz que essa classe na verdade é uma entidade no banco de dados
@Table(name = "tb_order") //O nome "Order" é reservado no SQL, essa anotação cria a tabela com outro nome
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")//Formatação da data e hora
	private Instant moment; //Pega o momento da compra, substitui o tipo Date
	
	private Integer orderStatus;
	
	@ManyToOne //Associação Muitos para um
	@JoinColumn(name = "client_id") //nome da chave estrangeira
	private User client;//Associação com a entidade 'User"
	
	public Order(){
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus ,User client) {
		super();
		this.id = id;
		this.moment = moment;		
		this.setOrderStatus(orderStatus);
		this.client = client;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}



	
	
	
}
