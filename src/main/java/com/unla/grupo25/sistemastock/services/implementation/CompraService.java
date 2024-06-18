package com.unla.grupo25.sistemastock.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.entities.Compra;
import com.unla.grupo25.sistemastock.repositories.ICompraRepository;
import com.unla.grupo25.sistemastock.services.ICompraService;

@Service("compraService")
public class CompraService implements ICompraService{
	
	private ICompraRepository compraRepository;
	
	public CompraService(ICompraRepository compraRepository) {
		this.compraRepository = compraRepository;
	}
	
	
	@Override
	public List<Compra> getAll() {
		return compraRepository.findAll();
	}

	@Override
	public Compra insertOrUpdate(Compra compraModel) {
		return compraRepository.save(compraModel);
	}

	@Override
	public boolean remove(int id) {
		try {
			compraRepository.deleteById(id);;
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
