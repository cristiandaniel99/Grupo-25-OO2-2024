package com.unla.grupo25.sistemastock.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.repositories.IProveedorRepository;
import com.unla.grupo25.sistemastock.services.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    public List<Proveedor> getAll() {
        return proveedorRepository.findAll();
    }
    
    public Optional<Proveedor> findById(int id) {
        return proveedorRepository.findById(id);
    }
    
}
