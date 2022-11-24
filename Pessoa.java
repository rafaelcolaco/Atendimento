package Atendimento;

import java.util.Calendar;
import java.util.Date;

public class Pessoa {

	private Date dataNascimento;
	private String nome;

	public Pessoa() {
	}

	public Pessoa(Date dataNascimento, String nome) {
		super();
		this.dataNascimento = dataNascimento;
		this.nome = nome;
	}

	@SuppressWarnings("deprecation")
	public int calcularIdade() {
		return Calendar.getInstance().get(Calendar.YEAR) - dataNascimento.getYear();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		if (dataNascimento != null)
			this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null)
			this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

}
