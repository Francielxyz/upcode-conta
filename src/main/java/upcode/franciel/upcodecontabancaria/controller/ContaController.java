package upcode.franciel.upcodecontabancaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.dto.TransacaoDTO;
import upcode.franciel.upcodecontabancaria.models.Conta;
import upcode.franciel.upcodecontabancaria.models.Transacao;
import upcode.franciel.upcodecontabancaria.models.enums.StatusTransacao;
import upcode.franciel.upcodecontabancaria.services.ContaService;

@RestController
@RequestMapping(value = "/api")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@RequestMapping(value = "conta/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> encontraId(@PathVariable Integer id) {
		Conta obj = contaService.encontraId(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "conta/deposito", method = RequestMethod.POST)
	public ResponseEntity<?> deposito(@RequestBody TransacaoDTO dados) {

		Transacao obj = contaService.deposito(dados.getId(), dados.getAgencia(), dados.getValor());

		if (obj != null) {
			if (obj.getStatus() == StatusTransacao.SUCCESSO) {
				return ResponseEntity.ok().body(obj);
			} else {
				if (obj.getStatus() == StatusTransacao.CONTA_NAO_ENCONTRADA)
					return ResponseEntity.status(400).body(obj);
			}
		}

		return ResponseEntity.status(400).body(null);

	}

	@RequestMapping(value = "conta/saque", method = RequestMethod.POST)
	public ResponseEntity<?> saque(@RequestBody TransacaoDTO dados) {
		Transacao obj = contaService.saque(dados.getId(), dados.getValor());

		if (obj != null) {
			if (obj.getStatus() == StatusTransacao.SUCCESSO) {
				return ResponseEntity.ok().body(obj);
			} else {
				return ResponseEntity.status(400).body(obj);
			}
		}

		return ResponseEntity.status(400).body(null);
	}

}
