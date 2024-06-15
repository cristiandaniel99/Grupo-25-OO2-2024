package com.unla.grupo25.sistemastock.dtos;

import com.unla.grupo25.sistemastock.entities.Producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class StockDTO {
	
	private int id;
	
	private Producto producto;
	
	private int cantidad;

    private int minimaStock;;

	public StockDTO(int id, Producto producto, int cantidad, int minimaStock) {
		this.setId(id);
		this.producto = producto;
		this.cantidad = cantidad;
		this.minimaStock = minimaStock;
	}
}
