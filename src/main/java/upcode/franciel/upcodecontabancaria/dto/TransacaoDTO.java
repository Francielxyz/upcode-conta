package upcode.franciel.upcodecontabancaria.dto;

import java.io.Serializable;

public class TransacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private double valor;
	private Integer id;
	private String agencia;
	private String ca;

	public TransacaoDTO() {

	}

	public TransacaoDTO(Integer id, String agencia, String ca, double valor) {
		this.id = id;
		this.agencia = agencia;
		this.ca = ca;
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setContaId(Integer id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

}
