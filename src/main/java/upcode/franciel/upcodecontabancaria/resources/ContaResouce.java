package upcode.franciel.upcodecontabancaria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upcode.franciel.upcodecontabancaria.models.Conta;
import upcode.franciel.upcodecontabancaria.repository.ContaRepository;

@RestController
@RequestMapping(value = "/api")
public class ContaResouce {

	@Autowired
	ContaRepository contaRepository;
	
	//Comentário 
	@GetMapping("/contas")
	public List<Conta> listaContar() {
		return contaRepository.findAll();
	}

	@GetMapping("/contas/{id}")
	public Conta listaContaUnica(@PathVariable(value = "id") long id) {
		return contaRepository.findById(id);
	}
	
	@PostMapping("/contas")
	public Conta salvarConta(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
}
