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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stockProducto", uniqueConstraints = @UniqueConstraint(columnNames = {"stockProducto","producto_id"}))
@Getter @Setter @NoArgsConstructor
public class StockProducto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED) private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "producto_id", nullable=false)
	private Producto producto;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="minimaStock")
    private int minimaStock;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(name="updatedat")
	@CreationTimestamp
	private LocalDate updatedAt;
 
}
