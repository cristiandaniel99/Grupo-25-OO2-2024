package com.unla.grupo25.sistemastock.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.repositories.IProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }
}
