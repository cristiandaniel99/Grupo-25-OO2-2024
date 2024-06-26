package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.entities.User;

public interface IStockRepository extends JpaRepository<StockProducto, Serializable>{
	
	
	@Query("SELECT s FROM StockProducto s JOIN FETCH s.producto p WHERE p.id = :productoId")
	public abstract StockProducto findByProductId(int productoId);
	
	@Query("SELECT s FROM StockProducto s JOIN FETCH s.producto WHERE s.cantidad < s.minimaStock")
    List<StockProducto> findProductosBajoStock();
}


