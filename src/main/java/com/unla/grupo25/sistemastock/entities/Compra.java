package com.unla.grupo25.sistemastock.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compra", uniqueConstraints = @UniqueConstraint(columnNames = {"compra","user_id", "producto_id"}))
@Getter  @Setter @NoArgsConstructor
public class Compra {
   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)private int idCompra;
	
	
   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn (name = "producto_id", nullable=false)
	private Producto producto;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_id", nullable=false)
	private User cliente;
	
	@Column(name="fechaCompra")
	@CreationTimestamp
	private LocalDate fechaCompra;
	
	@Column(name="cantidad")
	private int cantidad;

	public Compra(Producto producto, User cliente, LocalDate fechaCompra, int cantidad) {
		super();
		this.producto = producto;
		this.cliente = cliente;
		this.fechaCompra = fechaCompra;
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
