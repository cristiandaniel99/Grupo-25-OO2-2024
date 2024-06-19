package com.unla.grupo25.sistemastock.services.implementation;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.entities.Lote;
import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.repositories.ILoteRepository;
import com.unla.grupo25.sistemastock.services.ILoteService;
import com.unla.grupo25.sistemastock.services.IProductoService;

@Service("loteService")
public class LoteService implements ILoteService{

	ILoteRepository loteRepository;
	
	IProductoService productoService;
	
	
	
	public LoteService(ILoteRepository loteRepository, IProductoService productoService) {
		super();
		this.loteRepository = loteRepository;
		this.productoService = productoService;
	}


	@Override
	public Lote insertOrUpdate(Lote lote) {
		return loteRepository.save(lote);
	}
	
	@Override
	public Lote SetearLote(Producto producto, int cantidadRecibida, LocalDate fechaDeRecepcion, PedidoAprovisionamiento pedido, Proveedor proveedor) {
		Lote lote = new Lote();
        lote.setProducto(productoService.findById(producto.getId()));
        lote.setCantidadRecibida(cantidadRecibida);
        lote.setFechaDeRecepcion(LocalDate.now());
        lote.getPedidosDeAprov().add(pedido);
        lote.setPrecioCompra(productoService.findById(producto.getId()).getCosto()*cantidadRecibida);
        lote.setProveedor(proveedor);
        
        

       return insertOrUpdate(lote);
	}

	@Override
	public boolean remove(int id) {
		boolean bool;
		try {
			loteRepository.deleteById(id);
			bool= true;
		}catch (Exception e) {
			bool= false;
		}
		return bool;
	}
	
	
}
