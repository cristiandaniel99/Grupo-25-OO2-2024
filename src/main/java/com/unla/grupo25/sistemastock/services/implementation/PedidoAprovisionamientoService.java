package com.unla.grupo25.sistemastock.services.implementation;

import org.modelmapper.ModelMapper;

import com.unla.grupo25.sistemastock.dtos.PedidoAprovisionamientoDTO;
import com.unla.grupo25.sistemastock.dtos.ProductoDTO;
import com.unla.grupo25.sistemastock.entities.Compra;
import com.unla.grupo25.sistemastock.entities.PedidoAprovisionamiento;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.repositories.IPedidoAprovisionamientoRepository;
import com.unla.grupo25.sistemastock.repositories.IProductoRepository;
import com.unla.grupo25.sistemastock.repositories.IProveedorRepository;
import com.unla.grupo25.sistemastock.repositories.IStockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import com.unla.grupo25.sistemastock.services.IPedidoAprovisionamientoService;

@Service("PedidoAprovisionamientoService")
public class PedidoAprovisionamientoService implements IPedidoAprovisionamientoService {


	 @Autowired
	    private IStockRepository stockProductoRepository;

	    @Autowired
	    private IPedidoAprovisionamientoRepository pedidoAprovisionamientoRepository;

	    @Autowired
	    private IProveedorRepository proveedorRepository;

	    private ModelMapper modelMapper = new ModelMapper();
	    
	    @Transactional
	    public void generarPedidoDeAprovisionamiento(Integer productoId, Integer cantidad, Integer proveedorId) {
	        StockProducto stock = stockProductoRepository.findById(productoId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	        
	        PedidoAprovisionamiento pedido = new PedidoAprovisionamiento();
	        pedido.setProducto(stock.getProducto());
	        pedido.setCantidad(cantidad); // Cantidad ingresada por el usuario
	        pedido.setFecha(LocalDate.now());
	        pedido.setEstadoEntrega(false);
	        pedido.setTotal(stock.getProducto().getCosto() * cantidad); // Total calculado

	        // Obtener proveedor seleccionado por el usuario
	        Proveedor proveedor = proveedorRepository.findById(proveedorId).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
	        pedido.setProveedor(proveedor);

	        pedidoAprovisionamientoRepository.save(pedido);
	    }

	    public List<StockProducto> findProductosBajoStock() {
	        return stockProductoRepository.findProductosBajoStock();
	    }
	    
	    
	    @Override
	    public void insertOrUpdate(PedidoAprovisionamientoDTO pedidoDTO) {
	    	
	    	
	    	
	    	Integer productoId = pedidoDTO.getProducto().getId();
	        Integer cantidad = pedidoDTO.getCantidad();
	        Integer proveedorId = pedidoDTO.getProveedor().getId();

	        StockProducto stock = stockProductoRepository.findById(productoId)
	                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

	        PedidoAprovisionamiento pedido = new PedidoAprovisionamiento();
	        pedido.setProducto(stock.getProducto());
	        pedido.setCantidad(cantidad);
	        pedido.setFecha(LocalDate.now());
	        pedido.setEstadoEntrega(false);
	        pedido.setTotal(stock.getProducto().getCosto() * cantidad);

	        Proveedor proveedor = proveedorRepository.findById(proveedorId)
	                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
	        pedido.setProveedor(proveedor);

	        pedidoAprovisionamientoRepository.save(pedido);
	    }
	}
	

