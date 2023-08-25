package com.api.test;

import org.junit.jupiter.api.Test;

import com.api.model.Cliente;
import com.api.model.DireccionCliente;

import  static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ClienteModelTests {
	@Test
	void TestCliente() {
		List<DireccionCliente> direccionCliente=  new ArrayList<DireccionCliente>();
		direccionCliente.add(new DireccionCliente(1, "Chimborazo", "Riobamba", "Ciudadela la Paz",true));
		Cliente cliente = new Cliente((long) 1, "CI", "0605148402", "Bryan Alexander", "Pelaes Davalos", "bryanpelaes.1999@gmail.com", "0983358887",direccionCliente);
		assertEquals(direccionCliente,cliente.getDireccionCliente());
		assertEquals(1,cliente.getId());
		assertEquals("CI",cliente.getTipoIdentificacion());
		assertEquals("0605148402",cliente.getnumId());
		assertEquals("Bryan Alexander",cliente.getNombres());
		assertEquals("Pelaes Davalos",cliente.getApellidos());
		assertEquals("bryanpelaes.1999@gmail.com",cliente.getCorreo());
		assertEquals("0983358887",cliente.getNumeroCelular());
	}

}
