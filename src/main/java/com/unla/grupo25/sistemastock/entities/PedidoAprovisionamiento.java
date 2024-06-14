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
@Table(name = "pedidoAprovisionamiento", uniqueConstraints = @UniqueConstraint(columnNames = {"pedidoAprovisionamiento","producto_id", "proveedor_id"}))
@Getter @Setter @NoArgsConstructor
public class PedidoAprovisionamiento {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "producto_id", nullable=false)
	private Producto producto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "proveedor_id", nullable=false)
	private Proveedor proveedor;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "lote_id", nullable=false)
	private Lote lote;
	
	@Column(name="fecha")
	@CreationTimestamp
	private LocalDate fecha;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="total")
	private int total;
	
	@Column(name="estadoEntrega")
	private boolean estadoEntrega;

	public PedidoAprovisionamiento(Producto producto, Proveedor proveedor, LocalDate fecha, int cantidad, int total,
			boolean estadoEntrega) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
		this.estadoEntrega = estadoEntrega;
	}
	
	
	
	
}
