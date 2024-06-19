package com.unla.grupo25.sistemastock.services;

import java.util.List;
import java.util.Optional;

import com.unla.grupo25.sistemastock.entities.Proveedor;

public interface IProveedorService {

    public List<Proveedor> getAll();
    
    public Optional<Proveedor> findById(int id);
}
