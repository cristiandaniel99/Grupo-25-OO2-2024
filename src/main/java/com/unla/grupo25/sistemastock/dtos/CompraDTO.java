package com.unla.grupo25.sistemastock.dtos;

import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class CompraDTO {
	
	private int idCompra;
	
	private Producto producto;
	
	private User cliente;
	
	private int cantidad;

	public CompraDTO(Producto producto, User cliente, int cantidad) {
		this.producto = producto;
		this.cliente = cliente;
		this.cantidad = cantidad;
	}

}
