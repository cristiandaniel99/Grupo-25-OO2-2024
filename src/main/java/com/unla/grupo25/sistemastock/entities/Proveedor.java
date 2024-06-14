package com.unla.grupo25.sistemastock.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="proveedor")
@Getter  @Setter @NoArgsConstructor
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)private int idProveedor;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@Column(name="rubro")
	private String rubro;
	
	
	
	public Proveedor( String nombre, String direccion, String rubro) {
		super();
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.rubro = rubro;
	}
	
	
	
	
	
	
}
