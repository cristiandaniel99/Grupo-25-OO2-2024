package com.unla.grupo25.sistemastock.services;

import java.util.List;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.StockProducto;


public interface IStockService {

	public List<StockProducto> getAll();
	
	public StockDTO insertOrUpdate(StockDTO stockModel);
	
	//public StockDTO findByStockProductoId(int productoId);
	
	public boolean remove(int id);

	public void comprarProducto(int productoId, Integer cantidad);

}
