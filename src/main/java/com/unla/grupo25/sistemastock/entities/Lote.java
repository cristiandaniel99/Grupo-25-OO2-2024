package com.unla.grupo25.sistemastock.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lote", uniqueConstraints = @UniqueConstraint(columnNames = {"lote","producto_id"}))
@Getter@Setter @NoArgsConstructor
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED) private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	@Column(name = "cantidadRecibida")
	private int cantidadRecibida;

	@Column(name = "fechaDeRecepcion")
	@CreationTimestamp
	private LocalDate fechaDeRecepcion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lote")
	private Set<PedidoAprovisionamiento> pedidosDeAprov = new HashSet<PedidoAprovisionamiento>();

	@Column(name = "precioCompra")
	private int precioCompra;

	public Lote(Producto producto, int cantidadRecibida, LocalDate fechaDeRecepcion, int precioCompra) {
		super();
		this.producto = producto;
		this.cantidadRecibida = cantidadRecibida;
		this.fechaDeRecepcion = fechaDeRecepcion;
		this.precioCompra = precioCompra;
	}

}
