package com.api.test;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.api.model.Cliente;
import com.api.model.DireccionCliente;
import com.api.rest.ClienteRest;
import com.api.service.ClienteService;




@ExtendWith(MockitoExtension.class)
public class ClienteRestTest {
	
	@InjectMocks
	private ClienteRest clienteRest;

	@Mock
	private ClienteService clienteService;
	@Test
	public void listarClientesTest() {
		
		ResponseEntity <List<Cliente>> responseEntity = clienteRest.listarClientes();
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assertions.assertNotNull(responseEntity.getBody());
	}
	@Test
	public void crudClienteTest() {
		List<DireccionCliente> direccionCliente=  new ArrayList<DireccionCliente>();
		direccionCliente.add(new DireccionCliente(1, "Chimborazo", "Riobamba", "Ciudadela la Paz",true));
		Cliente cliente = new Cliente((long) 1, "CI", "0605148402", "Bryan Alexander", "Pelaes Davalos", "bryanpelaes.1999@gmail.com", "0983358887",direccionCliente);
		System.out.println(clienteService.createCliente(cliente));
		Assertions.assertEquals(clienteService.createCliente(cliente), clienteRest.getCliente("0605148402"));
		
		
	}

}
