package com.unla.grupo25.sistemastock.services;

import java.util.List;

import com.unla.grupo25.sistemastock.dtos.PedidoAprovisionamientoDTO;

import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;
import com.unla.grupo25.sistemastock.entities.StockProducto;

public interface IPedidoAprovisionamientoService {

	 public PedidoAprovisionamiento generarPedidoDeAprovisionamiento(Integer productoId, Integer cantidad, Integer proveedorId);
	 
	 public void insertOrUpdate(PedidoAprovisionamiento pedidoaprov);
	
	public List<StockProducto> findProductosBajoStock();
	
	
}
