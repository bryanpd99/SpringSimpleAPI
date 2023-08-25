package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.model.Cliente;
import com.api.model.DireccionCliente;
import com.api.repository.DireccionClienteRepository;

public class DireccionClienteService {
	@Autowired
	DireccionClienteRepository direccionClienteRepository;
	
	public DireccionCliente createDireccionCliente(DireccionCliente direccionCliente) {
		return direccionClienteRepository.save(direccionCliente);
	}

}
