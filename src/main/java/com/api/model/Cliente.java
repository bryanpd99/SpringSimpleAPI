package com.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, mappedBy = "idCliente")
	private List<DireccionCliente> direccionCliente = new ArrayList<DireccionCliente>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable = false, insertable=false)
	private Long id;
	private String tipoIdentificacion;
	@Column(unique = true)
	private String numId;
	private String nombres;
	private String apellidos;
	@Column(unique = true)
	private String correo;
	@Column(unique = true)
	private String numeroCelular;
	public Long getId() {
		return id;
	}
	public Cliente(){}
	public Cliente(Long id, String tipoIdentificacion, String numId, String nombres, String apellidos,
			String correo, String numeroCelular,List<DireccionCliente> direccionCliente) {
		this.id = id;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numId = numId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numeroCelular = numeroCelular;
		this.direccionCliente = direccionCliente;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getnumId() {
		return numId;
	}
	public void setnumId(String numId) {
		this.numId = numId;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setDireccionCliente(List<DireccionCliente> direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	public List<DireccionCliente>  getDireccionCliente() {
		return direccionCliente;
	}


}
