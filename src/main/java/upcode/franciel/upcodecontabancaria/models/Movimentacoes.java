package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_movimentacao")
public class Movimentacoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_movimentacao;

	@Column(name = "saldo")
	private double saldo;

	@ManyToOne
	private Cliente cliente;

	public Movimentacoes() {

	}

	public Movimentacoes(long id_movimentacao, double saldo, Cliente cliente) {
		super();
		this.id_movimentacao = id_movimentacao;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public long getId() {
		return id_movimentacao;
	}

	public void setId(long id_saldo) {
		this.id_movimentacao = id_saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo + 0;
	}

}
