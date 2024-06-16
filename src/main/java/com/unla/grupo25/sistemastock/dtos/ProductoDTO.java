package com.unla.grupo25.sistemastock.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter @NoArgsConstructor
public class ProductoDTO {

	
	

		
	private int id;
		
		
	    private String codigo;
	    
	
	    private String nombre;
	    
		
	    private String descripcion;
	    
		
	    private int costo;
	    
		
	    private int precioDeVenta;

		public ProductoDTO(int id,String codigo, String nombre, String descripcion, int costo, int precioDeVenta) {
			this.setId(id);
			this.codigo = codigo;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.costo = costo;
			this.precioDeVenta = precioDeVenta;
		}
	
	
	
}
