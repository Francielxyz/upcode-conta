package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_conta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta", referencedColumnName = "id_conta", nullable = false)
	private Saldo saldo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "data_cadastro")
	private Date data_cadastro;

	public long getId() {
		return id_conta;
	}

	public void setId(long id_conta) {
		this.id_conta = id_conta;
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
