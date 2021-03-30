package upcode.franciel.upcodecontabancaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import upcode.franciel.upcodecontabancaria.models.Movimentacoes;
import upcode.franciel.upcodecontabancaria.repository.MovimentacoesRepository;

@Service
@Qualifier("SaldoService")
public class MovimentacoesService {

	@Autowired
	private MovimentacoesRepository repository;

	public Movimentacoes buscaId(Long id_movimentacao) {
		Optional<Movimentacoes> obj = repository.findById(id_movimentacao);

		if (obj.orElse(null) == null) {
			throw new RuntimeException("Conta não Encontrada");
		}

		return obj.orElse(null);
	}

	public String deposito(long id_movimentacao, double valor) {

		try {
//			Movimentacoes saldoInicial = repository.findById(id).orElseThrow(() -> new Exception());
			Movimentacoes saldoInicial = repository.findById(id_movimentacao);

			if (saldoInicial == null) {

				Movimentacoes movimentacoes = new Movimentacoes();
				movimentacoes.setId(id_movimentacao);
				movimentacoes.setSaldo(valor);
				repository.save(movimentacoes);

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

	public String saque(long id_movimentacao, double valor) {
		try {
			Movimentacoes saldoInicial = repository.findById(id_movimentacao);

			if (saldoInicial == null) {
				return "Saldo insuficiente para realziar saque";
			}
			if (saldoInicial.getSaldo() < valor) {
				return "Valor para saque insuficiente";
			} else {
				saldoInicial.setSaldo(saldoInicial.getSaldo() - valor);
				repository.save(saldoInicial);
				return "Saque realizado com sucesso";
			}

		} catch (Exception e) {
			return "Erro ao realziar Saque";
		}

	}

}
