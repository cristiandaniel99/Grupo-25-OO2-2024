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
@Getter  @Setter @NoArgsConstructor
@Table(name="producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED) private int id;
	
	@Column(name="codigo", nullable=false)
    private String codigo;
    
	@Column(name="nombre")
    private String nombre;
    
	@Column(name="descripcion")
    private String descripcion;
    
	@Column(name="costo")
    private int costo;
    
	@Column(name="precioDeVenta")
    private int precioDeVenta;

	public Producto(String codigo, String nombre, String descripcion, int costo, int precioDeVenta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.precioDeVenta = precioDeVenta;
	}
	
	
	
}
