package upcode.franciel.upcodecontabancaria.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upcode.franciel.upcodecontabancaria.models.Conta;
import upcode.franciel.upcodecontabancaria.models.Deposito;
import upcode.franciel.upcodecontabancaria.models.Saque;
import upcode.franciel.upcodecontabancaria.models.Transacao;
import upcode.franciel.upcodecontabancaria.models.enums.StatusTransacao;
import upcode.franciel.upcodecontabancaria.repository.ContaRepository;
import upcode.franciel.upcodecontabancaria.repository.TransacoesRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repoConta;
	
	@Autowired
	private TransacoesRepository repoTransacao;

	public Conta encontraId(Integer id) {
		Optional<Conta> obj = repoConta.findById(id);
		
		if(obj.orElse(null) == null) {
			throw new RuntimeException("Conta não encontrado");
		}
		
		return obj.orElse(null);
	}
	
	public Transacao deposito(Integer id_conta, String agencia, double valor) {
		Optional<Conta> deposito = repoConta.findById(id_conta);
//		Optional<Conta> passivo = repoConta.findByAgenciaAndCa(agencia_passiva, ca_passiva);
		
		Transacao t1 = null;
		
		if(deposito.orElse(null) != null) {
			Conta ca1 = deposito.orElse(null);
			
			t1 = new Deposito();
			
			StatusTransacao status = t1.transacao(); 
			
			if(StatusTransacao.SUCCESSO == status) {
				ca1.getTransacoes().add(t1);
				repoConta.saveAll(Arrays.asList(ca1));
				
				repoTransacao.save(t1);
				
				return t1;
			}
		}
		
		t1 = new Deposito();
		t1.setStatus(StatusTransacao.CONTA_NAO_ENCONTRADA);
		
		return t1;
	}
	
	public Transacao saque(Integer id, double valor) {
		Optional<Conta> ativo = repoConta.findById(id);
		
		Transacao t1 = null;
		
		if(ativo.orElse(null) != null) {
			Conta ca1 = ativo.orElse(null);
			
			t1 = new Saque();
			
			StatusTransacao status = t1.transacao(); 
			
			if(StatusTransacao.SUCCESSO == status) {
				ca1.getTransacoes().add(t1);
				repoConta.save(ca1);
				
				repoTransacao.save(t1);
			}
		}
		
		return t1;
	}
}
