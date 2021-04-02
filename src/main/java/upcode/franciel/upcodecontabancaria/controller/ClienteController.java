package upcode.franciel.upcodecontabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.models.Cliente;
import upcode.franciel.upcodecontabancaria.models.Transacao;
import upcode.franciel.upcodecontabancaria.repository.ClienteRepository;
import upcode.franciel.upcodecontabancaria.repository.TransacoesRepository;
import upcode.franciel.upcodecontabancaria.services.ClienteService;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TransacoesRepository transacoesRepository;

	@PostMapping("/addCliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping("/clientes")
	public List<Cliente> listaCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("/extrato")
	public List<Transacao> listaExtrato() {
		return transacoesRepository.findAll();
	}

	@RequestMapping(value = "cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> encontrarId(@PathVariable Integer id) {
		Cliente obj = clienteService.encontrarId(id);

		return ResponseEntity.ok().body(obj);
	}

}
