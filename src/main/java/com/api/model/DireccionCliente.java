package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class DireccionCliente {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	private String provincia;
	private String ciudad;
	private String direccion;
	private boolean esMatriz = false;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( foreignKey = @ForeignKey(name = "fk_direccion_cliente_id"), name="cliente_id", referencedColumnName = "id")
    private Cliente idCliente;
	public DireccionCliente() {}
	public DireccionCliente(long id, String provincia, String ciudad, String direccion,boolean esMatriz) {
		this.id = id;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.esMatriz = esMatriz;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean getEsMatriz() {
		return esMatriz;
	}

	public void setEsMatriz(boolean esMatriz) {
		this.esMatriz = esMatriz;
	}
	public String toString() {
		return provincia+ " - "+ciudad+ " - "+direccion+" \n"+ idCliente ;
		
	}

}
