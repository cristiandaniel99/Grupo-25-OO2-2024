package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo25.sistemastock.entities.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Serializable> {

	
}
