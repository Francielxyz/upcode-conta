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
	private String agencia;
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

	public Conta(Integer id, String agencia, double saldo, Cliente cliente) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		return true;
	}

}
