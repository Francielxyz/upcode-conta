package upcode.franciel.upcodecontabancaria.models;

import javax.persistence.Entity;

import upcode.franciel.upcodecontabancaria.models.enums.StatusTransacao;

@Entity
public class Saque extends Transacao {
	private static final long serialVersionUID = 1L;

	private Double valor;

	public Saque() {

	}

	public Saque(Integer id, Integer status, Conta conta, Double valor) {
		super(id, status, "Saque", conta);
		this.valor = valor;
	}

	@Override
	public StatusTransacao transacao() {

		if (this.getConta().getSaldo() >= this.valor) {
			this.getConta().subSaldo(valor);
			super.setStatus(StatusTransacao.SUCCESSO);
		} else {
			super.setStatus(StatusTransacao.SALDO_INSUFICIENTE);

		}

		return this.getStatus();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
