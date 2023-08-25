package com.api.service;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.api.model.Cliente;
import com.api.model.DireccionCliente;
import com.api.repository.ClienteRepository;
import com.api.repository.DireccionClienteRepository;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DireccionClienteRepository direccionClienteRepository ;

	public Cliente createCliente(Cliente cliente) {
		DireccionCliente direccionCliente = cliente.getDireccionCliente().get(0);
		direccionCliente.setIdCliente(cliente);
		direccionCliente.setEsMatriz(true);
		direccionClienteRepository.save(direccionCliente);
		
		return clienteRepository.save(cliente);
	}
	public Cliente updateCliente(Cliente requestCliente) {
		Cliente updatedCliente = clienteRepository.findBynumId(requestCliente.getnumId());
		updatedCliente.setNombres(requestCliente.getNombres());
		updatedCliente.setApellidos(requestCliente.getApellidos());
		updatedCliente.setCorreo(requestCliente.getCorreo());
		updatedCliente.setNumeroCelular(requestCliente.getNumeroCelular()); 
		updatedCliente.getDireccionCliente().addAll(requestCliente.getDireccionCliente());
		return clienteRepository.save(updatedCliente);
	}

	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	public void deleteCliente(String numId) {
		clienteRepository.deleteBynumId(numId);
	}
	public Cliente getBynumId (String numId) {
		return clienteRepository.findBynumId(numId);
	}
	public List<Cliente> getBynombres (String nombres) {
		return clienteRepository.findBynombres(nombres);
	}
	
	public void addDireccionCliente(DireccionCliente direccionCliente, String numId) {
		Cliente clientWithDireccion = clienteRepository.findBynumId(numId);
		direccionCliente.setIdCliente(clientWithDireccion);
		System.out.println(direccionCliente);
		direccionClienteRepository.save(direccionCliente);

	}
	public List<DireccionCliente> getDirecciones(String numId) {
		Cliente clientWithDirecciones = clienteRepository.findBynumId(numId);
		System.out.println(clientWithDirecciones.getDireccionCliente());
		return clientWithDirecciones.getDireccionCliente();
	}
	


}
