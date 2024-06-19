package com.unla.grupo25.sistemastock.services;

import com.unla.grupo25.sistemastock.entities.Lote;

public interface ILoteService {
	
	public Lote insertOrUpdate(Lote lote);
	
	public boolean remove(int id);
}
