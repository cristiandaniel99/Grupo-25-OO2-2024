package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.User;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {
	
	public Producto findById(int id);
	
	@Query("SELECT p FROM Producto p WHERE p.id = :productoId")
	public Producto findByid(int productoId);
	
	public boolean existsByCodigo(String codigo);
}
