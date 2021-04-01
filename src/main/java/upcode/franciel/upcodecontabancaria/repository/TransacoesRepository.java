package upcode.franciel.upcodecontabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upcode.franciel.upcodecontabancaria.models.Transacao;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacao, Integer>{

}