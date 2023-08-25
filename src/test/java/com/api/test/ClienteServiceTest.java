package com.api.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.model.Cliente;
import com.api.model.DireccionCliente;
import com.api.repository.ClienteRepository;
import com.api.service.ClienteService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
	
	@InjectMocks
	private ClienteService clienteService;
	@Mock
	private ClienteRepository clienteRepository;
	@Test
	public void test() {
		List<DireccionCliente> direccionCliente = new ArrayList<DireccionCliente>() {
			{
				add(new DireccionCliente(1, "Chimborazo", "Riobamba", "Ciudadela la Paz",true));

			}
			};
		clienteRepository.save(new Cliente((long) 1, "CI", "0605148402", "Bryan Alexander", "Pelaes Davalos", "bryanpelaes.1999@gmail.com", "0983358887",direccionCliente));
		Cliente cliente = clienteService.getBynumId("0605148402");
		assertNotNull(5);
		
	}

}
