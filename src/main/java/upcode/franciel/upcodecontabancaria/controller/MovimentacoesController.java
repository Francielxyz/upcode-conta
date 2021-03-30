package upcode.franciel.upcodecontabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.models.Movimentacoes;
import upcode.franciel.upcodecontabancaria.repository.MovimentacoesRepository;

@RestController
@RequestMapping(value = "/api")
public class MovimentacoesController {

	@Autowired
	MovimentacoesRepository movimentacoesRepository;

	@GetMapping("/movimentacao")
	public List<Movimentacoes> listaSaldo() {
		return movimentacoesRepository.findAll();
	}

	@GetMapping("/movimentacao/{id_movimentacao}")
	public Movimentacoes consultarSaldo(@PathVariable(value = "id_movimentacao") long id_saldo) {
		return movimentacoesRepository.findById(id_saldo);
	}

	@PostMapping("/saldo")
	public Movimentacoes salvarSaldo(@RequestBody Movimentacoes saldo_saldo) {
		return movimentacoesRepository.save(saldo_saldo);
	}
	
//	@PutMapping("/saldo/saque")
//	public Saldo saque(long id, double valor) {
//		
//	}

//	@GetMapping("/saldo/{id}")
//	public Saldo consultarSaldo(Long id) {
//		return saldoRepository.consultarSaldo(id);
//	}
//
//	@GetMapping("/extrato/{id_saldo}")
//	public Saldo consultarExtrato(@PathVariable(value = "id_saldo") long id,
//			@PathVariable(value = "id_conta") long num_conta) {
//
//		return saldoRepository.consultarExtrato(id, num_conta);
//	}

}
