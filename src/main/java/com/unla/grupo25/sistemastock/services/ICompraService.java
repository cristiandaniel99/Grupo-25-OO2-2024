package com.unla.grupo25.sistemastock.services;

import java.util.List;

import com.unla.grupo25.sistemastock.entities.Compra;

public interface ICompraService {
	
	public List<Compra> getAll();
	
	public Compra insertOrUpdate(Compra compraModel);
	
	public boolean remove(int id);
	
}
