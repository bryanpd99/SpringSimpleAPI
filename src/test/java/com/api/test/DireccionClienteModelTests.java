package com.api.test;

import org.junit.jupiter.api.Test;

import com.api.model.DireccionCliente;
import  static org.junit.jupiter.api.Assertions.assertEquals;
public class DireccionClienteModelTests {
	@Test
	public void TestDireccioncliente() {
		DireccionCliente direccionCliente = new DireccionCliente(1, "Chimborazo", "Riobamba", "Ciudadela la Paz",true);
		assertEquals(1,direccionCliente.getId());
		assertEquals("Chimborazo",direccionCliente.getProvincia());
		assertEquals("Riobamba",direccionCliente.getCiudad());
		assertEquals("Ciudadela la Paz",direccionCliente.getDireccion());
		assertEquals(true,direccionCliente.getEsMatriz());

	}

}
