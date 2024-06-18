package com.unla.grupo25.sistemastock.dtos;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.unla.grupo25.sistemastock.entities.Lote;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.Proveedor;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PedidoAprovisionamientoDTO {

	private int id;

	private Producto producto;

	private Proveedor proveedor;

	private Lote lote;

	private LocalDate fecha;

	private int cantidad;

	private int total;

	private boolean estadoEntrega;

	public PedidoAprovisionamientoDTO(int id,Producto producto, Proveedor proveedor, LocalDate fecha, int cantidad, int total,
			boolean estadoEntrega) {
		super();
		this.setId(id);
		this.producto = producto;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
		this.estadoEntrega = estadoEntrega;
	}

}
