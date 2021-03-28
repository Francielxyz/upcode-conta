package upcode.franciel.upcodecontabancaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upcode.franciel.upcodecontabancaria.models.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {
	
//	@Query("SELECT s.saldo FROM TB_Saldo s WHERE s.id = ?1")
//	Saldo consultarSaldo(long contaId);
//	
//	@Query("SELECT CASE WHEN (COUNT(*) > 0) THEN TRUE ELSE FALSE END FROM TB_conta c WHERE c.id = ?1 AND c.num_conta = ?2")
//	Saldo consultarExtrato(long contaId, long saldoId);
//	

}
