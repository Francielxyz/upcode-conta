package upcode.franciel.upcodecontabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upcode.franciel.upcodecontabancaria.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
}
