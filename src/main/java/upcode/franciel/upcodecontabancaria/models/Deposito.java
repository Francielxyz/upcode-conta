package upcode.franciel.upcodecontabancaria.models;

import javax.persistence.Entity;

import upcode.franciel.upcodecontabancaria.models.enums.StatusTransacao;

@Entity
public class Deposito extends Transacao {
	private static final long serialVersionUID = 1L;

	private Double valor;

	public Deposito() {

	}

	public Deposito(Integer id, Integer status, Conta conta, Double valor) {
		super(id, status, "Deposito", conta);
		this.valor = valor;
	}

	@Override
	public StatusTransacao transacao() {
		this.getConta().subSaldo(valor);
		super.setStatus(StatusTransacao.SUCCESSO);
		return this.getStatus();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
