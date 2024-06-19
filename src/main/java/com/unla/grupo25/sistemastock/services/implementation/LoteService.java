package com.unla.grupo25.sistemastock.services.implementation;

import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.entities.Lote;
import com.unla.grupo25.sistemastock.repositories.ILoteRepository;
import com.unla.grupo25.sistemastock.services.ILoteService;

@Service("loteService")
public class LoteService implements ILoteService{

	ILoteRepository loteRepository;
	
	public LoteService(ILoteRepository loteRepository) {
		this.loteRepository = loteRepository;
	}
	
	
	@Override
	public Lote insertOrUpdate(Lote lote) {
		return loteRepository.save(lote);
	}

	@Override
	public boolean remove(int id) {
		boolean bool;
		try {
			loteRepository.deleteById(id);
			bool= true;
		}catch (Exception e) {
			bool= false;
		}
		return bool;
	}
	
	
}
