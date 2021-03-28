package upcode.franciel.upcodecontabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upcode.franciel.upcodecontabancaria.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findById (long id_cliente);	
}
