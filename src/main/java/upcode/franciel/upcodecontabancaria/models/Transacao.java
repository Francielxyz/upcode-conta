package upcode.franciel.upcodecontabancaria.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import upcode.franciel.upcodecontabancaria.models.enums.StatusTransacao;

@Entity
@Table(name = "TB_transacoes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer status;
	private String tipo;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta conta;

	public Transacao() {

	}

	public Transacao(Integer id, Integer status, String tipo, Conta conta) {
		super();
		this.id = id;
		this.status = status;
		this.tipo = tipo;
		this.conta = conta;
	}

	public abstract StatusTransacao transacao();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusTransacao getStatus() {
		return StatusTransacao.toEnum(status);
	}

	public void setStatus(StatusTransacao status) {
		this.status = status.getCodigo();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Transacao other = (Transacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
