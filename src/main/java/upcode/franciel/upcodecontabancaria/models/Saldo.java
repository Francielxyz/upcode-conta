package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "TB_saldo")
public class Saldo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_saldo;

	@Column(name = "saldo")
	private double saldo;

	@JoinColumn(name = "id_conta")
	private Conta conta;

	public long getId() {
		return id_saldo;
	}

	public void setId(long id_saldo) {
		this.id_saldo = id_saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
