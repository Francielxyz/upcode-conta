package upcode.franciel.upcodecontabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upcode.franciel.upcodecontabancaria.models.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {
	
}
