package com.unla.grupo25.sistemastock.services.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.dtos.ProductoDTO;
import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.repositories.IProductoRepository;
import com.unla.grupo25.sistemastock.repositories.IStockRepository;
import com.unla.grupo25.sistemastock.services.IProductoService;
import com.unla.grupo25.sistemastock.services.IStockService;
@Service("productoService")
public class ProductoService implements IProductoService{


		
		private IProductoRepository productoRepository;
		
		private ModelMapper modelMapper = new ModelMapper();
		
		public ProductoService(IProductoRepository productoRepository) {
			this.productoRepository = productoRepository;
		}
		
		 public Producto findById(int id) {
		        return productoRepository.findById(id);
		    }
		
		@Override
		public List<Producto> getAll(){
			return productoRepository.findAll();
		}
		
		 public boolean existsByCodigo(String codigo) {
		        return productoRepository.existsByCodigo(codigo);
		    }
		
		@Override
		public ProductoDTO insertOrUpdate(ProductoDTO productoDTO) {
			Producto producto=null;
			if(!productoRepository.existsByCodigo(productoDTO.getCodigo())) {
				producto = productoRepository.save(modelMapper.map( productoDTO, Producto.class));
			}
			else {
				throw new RuntimeException("El producto con este codigo ya existe");
			}

			
			return modelMapper.map(producto, ProductoDTO.class);
		}
		
		
		
		
		@Override
		public boolean remove(int id) {
			boolean bool;
			try {
				productoRepository.deleteById(id);
				
				bool= true;
			}catch (Exception e) {
				bool= false;
			}
			return bool;
		}
	
}
