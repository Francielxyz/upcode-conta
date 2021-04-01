package upcode.franciel.upcodecontabancaria.models.enums;

public enum StatusTransacao {

	SUCCESSO(1, "Sucesso"), 
	NEGADO(2, "Negado"), 
	ERRO(3, "Erro"), 
	PROCESSANDO(4, "Processando"),
	SALDO_INSUFICIENTE(5, "Saldo Insuficiente"), 
	CONTA_NAO_ENCONTRADA(6, "Conta não encontrada");

	private int codigo;
	private String descricao;

	private StatusTransacao() {

	}

	private StatusTransacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static StatusTransacao toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (StatusTransacao x : StatusTransacao.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id: " + codigo + " Invalido");
	}
}
