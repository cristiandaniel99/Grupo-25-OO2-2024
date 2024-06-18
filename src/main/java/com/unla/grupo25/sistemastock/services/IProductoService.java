package com.unla.grupo25.sistemastock.services;

import java.util.List;
import java.util.Optional;

import com.unla.grupo25.sistemastock.dtos.ProductoDTO;
import com.unla.grupo25.sistemastock.entities.Producto;

public interface IProductoService {

	public List<Producto>getAll();
	
	public Optional <Producto> findById(int id);
	
	public ProductoDTO insertOrUpdate(ProductoDTO productoModel);
	
	public boolean remove(int id);
	
	public boolean existsByCodigo(String codigo);
	
	public ProductoDTO Update(ProductoDTO productoModel);
}
