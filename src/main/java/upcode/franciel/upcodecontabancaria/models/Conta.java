package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_conta")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(unique = true, nullable = false)
	private String num_conta;
	@Column(nullable = false)
	private double saldo;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cliente_id")
	@MapsId
	private Cliente cliente;

	@OneToMany(mappedBy = "conta")
	private List<Transacao> transacoes = new ArrayList<>();

	public Conta() {

	}

	public Conta(Integer id, String num_conta, double saldo, Cliente cliente) {
		super();
		this.id = id;
		this.num_conta = num_conta;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void addSaldo(double saldo) {
		this.saldo += saldo;
	}

	public void subSaldo(double saldo) {
		this.saldo -= saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoess(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

}
