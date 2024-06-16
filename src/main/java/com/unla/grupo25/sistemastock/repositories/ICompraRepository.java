package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo25.sistemastock.entities.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Serializable>{

}
