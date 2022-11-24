package Atendimento;

import java.util.Date;

public class Paciente extends Pessoa {

	public Paciente() {
		super();
	}
	
	public Paciente(Date dataNascimento, String nome) {
		super(dataNascimento, nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
