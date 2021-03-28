package upcode.franciel.upcodecontabancaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.models.Conta;
import upcode.franciel.upcodecontabancaria.models.Saldo;
import upcode.franciel.upcodecontabancaria.repository.SaldoRepository;

@RestController
@RequestMapping(value = "/api")
public class SaldoController {

	@Autowired
	SaldoRepository saldoRepository;
	
	@GetMapping("/saldo/{id_saldo}")
	public Saldo consultarSaldo(Long id_saldo) {
		return saldoRepository.getOne(id_saldo);
	}
	
	@PostMapping("/saldo")
	public Saldo salvarSaldo(@RequestBody Saldo saldo_saldo) {
		return saldoRepository.save(saldo_saldo);
	}

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
