package upcode.franciel.upcodecontabancaria.dto;

import java.io.Serializable;

import upcode.franciel.upcodecontabancaria.models.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
