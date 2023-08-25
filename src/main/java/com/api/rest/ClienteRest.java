package com.api.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.api.exception.ClienteNotFound;
import com.api.exception.ExistingCliente;
import com.api.model.Cliente;
import com.api.model.DireccionCliente;
import com.api.service.ClienteService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1")
public class ClienteRest {
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cliente")
	public Cliente newCliente(@RequestBody Cliente cliente){
		if (clienteService.getBynumId(cliente.getnumId())!=null) throw new ExistingCliente();
		return clienteService.createCliente(cliente);
	}
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>>  listarClientes(){
		return ResponseEntity.ok(clienteService.getAllClientes());
	}
	@DeleteMapping("/cliente/{numId}")
	public ResponseEntity<Void> deleteClientes(@PathVariable ("numId") String numId){
		if (clienteService.getBynumId(numId)==null) throw new ClienteNotFound();
		clienteService.deleteCliente(numId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/cliente/{numId}")
	public Cliente getCliente(@PathVariable ("numId") String numId){
		if (clienteService.getBynumId(numId)==null) throw new ClienteNotFound();
		return clienteService.getBynumId(numId);
	}
	
	@GetMapping("/cliente")
	public List<Cliente>getClienteByName(@RequestParam String nombres){
		return clienteService.getBynombres(nombres);
	}
	
	@PutMapping("/cliente")
	public Cliente editCliente(@RequestBody Cliente requestCliente){
		return clienteService.updateCliente(requestCliente);
	}
	
	@PostMapping(value = "/cliente/{numId}/direccion")
	public ResponseEntity<Void> newDireccionCliente(@RequestBody DireccionCliente direccionCliente,@PathVariable ("numId") String numId){
		if (clienteService.getBynumId(numId)==null) throw new ClienteNotFound();
		clienteService.addDireccionCliente(direccionCliente,numId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/cliente/{numId}/direccion")
	public List<DireccionCliente> getDireccionesCliente(@PathVariable ("numId") String numId){
		if (clienteService.getBynumId(numId)==null) throw new ClienteNotFound();
		System.out.println("listando direcciones...");
		return clienteService.getDirecciones(numId);
	}
	
	

}
