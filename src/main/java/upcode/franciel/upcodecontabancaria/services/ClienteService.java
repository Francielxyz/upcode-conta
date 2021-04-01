package upcode.franciel.upcodecontabancaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upcode.franciel.upcodecontabancaria.models.Cliente;
import upcode.franciel.upcodecontabancaria.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repoCliente;

	public Cliente encontrarId(Integer id) {
		Optional<Cliente> obj = repoCliente.findById(id);
		
		return obj.orElse(null); 
	}
}
