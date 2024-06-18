package com.unla.grupo25.sistemastock.services;

import java.util.List;

import com.unla.grupo25.sistemastock.dtos.PedidoAprovisionamientoDTO;

import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;
import com.unla.grupo25.sistemastock.entities.StockProducto;

public interface IPedidoAprovisionamientoService {

	 public void generarPedidoDeAprovisionamiento(Integer productoId, Integer cantidad, Integer proveedorId);
	 
	 public void insertOrUpdate(PedidoAprovisionamientoDTO pedidoaprovDTO);
	
	public List<StockProducto> findProductosBajoStock();
}
