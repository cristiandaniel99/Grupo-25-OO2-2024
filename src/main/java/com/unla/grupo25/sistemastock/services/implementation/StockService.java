package com.unla.grupo25.sistemastock.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.repositories.IStockRepository;
import com.unla.grupo25.sistemastock.services.IStockService;

@Service("stockService")
public class StockService implements IStockService{
	
	private IStockRepository stockRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public StockService(IStockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	
	@Override
	public List<StockProducto> getAll(){
		return stockRepository.findAll();
	}
	
	@Override
	public StockDTO insertOrUpdate(StockDTO stockDTO) {
		StockProducto stock = stockRepository.save(modelMapper.map(stockDTO, StockProducto.class));
		return modelMapper.map(stock, StockDTO.class);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			stockRepository.deleteById(id);;
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public void comprarProducto(int productoId, Integer cantidad) {
		
		StockProducto stockProducto = stockRepository.findByProductId(productoId);
        if (stockProducto != null) {
            int stockDisponible = stockProducto.getCantidad();
            if (cantidad <= stockDisponible) {
                stockProducto.setCantidad(stockDisponible - cantidad);
                stockRepository.save(stockProducto);
            } else {
                throw new RuntimeException("La cantidad a comprar excede el stock disponible");
            }
        } else {
            throw new RuntimeException("El producto no está disponible en el stock");
        }
        
        
        //la verificacion de niveles de minima stock y lanzar una alta de pedido de aprovisionamiento en caso de ser necesario
		
	}

}
