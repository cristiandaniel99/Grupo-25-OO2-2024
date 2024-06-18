package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;

@Repository
public interface IPedidoAprovisionamientoRepository extends JpaRepository<PedidoAprovisionamiento, Serializable> {

}
