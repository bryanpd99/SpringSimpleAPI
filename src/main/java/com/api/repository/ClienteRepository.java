package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findBynumId(String numId);

	List<Cliente> findBynombres(String nombres);

	void deleteBynumId(String numId);
}
