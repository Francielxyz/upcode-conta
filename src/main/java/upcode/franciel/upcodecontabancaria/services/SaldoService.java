package upcode.franciel.upcodecontabancaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import upcode.franciel.upcodecontabancaria.models.Saldo;
import upcode.franciel.upcodecontabancaria.repository.SaldoRepository;

@Service
@Qualifier("SaldoService")
public class SaldoService {

	@Autowired
	private SaldoRepository repository;

	public String deposito(long id, double valor) {

		try {
//			Saldo saldoInicial = repository.findById(id).orElseThrow(() -> new Exception());
			Saldo saldoInicial = repository.findById(id);

			if (saldoInicial == null) {

				Saldo saldo = new Saldo();
				saldo.setId(id);
				saldo.setSaldo(valor);
				repository.save(saldo);

			} else {

				saldoInicial.setSaldo(saldoInicial.getSaldo() + valor);
				repository.save(saldoInicial);
				// Conta conta = repository.findById(id).orElseThrow( () -> new
				// SaldoException("Deposito com Sucesso " + id));

			}
			return "Depósito feito com Sucesso";

		} catch (Exception e) {
			return "Erro ao realizar depósito";
		}

	}

	public String saque(long id, double valor) {
		try {
			Saldo saldoInicial = repository.findById(id);

			if (saldoInicial == null) {
				return "Saldo insuficiente para realziar saque";
			}
			if (saldoInicial.getSaldo() < valor) {
				return "Valor para saque insuficiente";
			}
			else {
				saldoInicial.setSaldo(saldoInicial.getSaldo() - valor);
				repository.save(saldoInicial);
				return "Saque realizado com sucesso";
			}

		} catch (Exception e) {
			return "Erro ao realziar Saque";
		}

	}

}
