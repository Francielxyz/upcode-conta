package upcode.franciel.upcodecontabancaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.mfmNoticias.exception.ResourceNotFoundException;
import com.project.mfmNoticias.model.User;

import upcode.franciel.upcodecontabancaria.models.Saldo;
import upcode.franciel.upcodecontabancaria.repository.SaldoRepository;

@Service
@Qualifier("SaldoService")
public class SaldoService {

	@Autowired
	private SaldoRepository repository;

	public String deposito(Long id, Double valor) {

		Saldo saldoInicial = repository.findById(id).orElseThrow(() -> new Exception());
		
		if (saldoInicial.isEmpty()) {
			Saldo saldo = new Saldo();
			saldo.setId(id);
			saldo.setSaldo(valor);
			repository.save(saldo);
		}else {
//			saldoInicial.setSaldo(saldoInicial.get() + valor);
//			repository.save(saldoInicial);
//			User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND + id));
			
		}
			

		return "Depósito feito com Sucesso";
	}

}
