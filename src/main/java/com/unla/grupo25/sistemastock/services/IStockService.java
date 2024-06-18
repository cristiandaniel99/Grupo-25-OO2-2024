package com.unla.grupo25.sistemastock.services;

import java.util.List;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.StockProducto;


public interface IStockService {

	public List<StockProducto> getAll();
	
	public StockProducto insertOrUpdate(StockProducto stockProducto);
	
	public StockProducto findByStockProductoId(int productoId);
	
	public boolean remove(int id);

	public void BajaStockPorCompra(int productoId, Integer cantidad);

}
