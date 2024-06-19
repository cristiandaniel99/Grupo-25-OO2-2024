package com.unla.grupo25.sistemastock.services;

import java.time.LocalDate;

import com.unla.grupo25.sistemastock.entities.Lote;
import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.Proveedor;

public interface ILoteService {
	
	public Lote insertOrUpdate(Lote lote);
	
	public boolean remove(int id);
	
	public Lote SetearLote(Producto producto, int cantidadRecibida, LocalDate fechaDeRecepcion, PedidoAprovisionamiento pedido, Proveedor proveedor);
}
