package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cliente;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "data_cadastro")
	private Date data_cadastro;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "saldo")
	private List<Movimentacoes> movimentacoes = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(long id_cliente, String nome, String cpf, Date data_nasc, Date data_cadastro,
			List<Movimentacoes> movimentacoes) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.data_cadastro = data_cadastro;
		this.movimentacoes = movimentacoes;
	}

	public long getId() {
		return id_cliente;
	}

	public void setId(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Date getDataCadastro() {
		return data_cadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.data_cadastro = dataCadastro;
	}

}
