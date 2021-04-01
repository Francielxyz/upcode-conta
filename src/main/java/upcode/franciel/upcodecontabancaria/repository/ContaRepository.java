package upcode.franciel.upcodecontabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upcode.franciel.upcodecontabancaria.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}