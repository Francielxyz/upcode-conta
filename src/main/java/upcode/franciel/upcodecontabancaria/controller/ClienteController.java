package upcode.franciel.upcodecontabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.models.Cliente;
import upcode.franciel.upcodecontabancaria.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listaCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("/cliente/{id_cliente}")
	public Cliente listaUnicoCliente(@PathVariable(value = "id_cliente") long id_cliente) {
		return clienteRepository.findById(id_cliente);
	}

	@PostMapping("/cliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
