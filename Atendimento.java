package Atendimento;

import java.util.Date;

public class Atendimento extends Operacao {

	private int prioridade;
	private int estado;
	private Medico medico;
	private Paciente paciente;

	public Atendimento() {
		super();
	}

	public Atendimento(Date inicio, Date fim) {
		super(inicio, fim);
	}
	
	public Atendimento(Date inicio, Date fim, int prioridade, int estado, Medico medico, Date dataNascimento, String nome) {
		super(inicio, fim);
		this.prioridade = prioridade;
		this.estado = estado;
		this.medico = medico;
		paciente = new Paciente(dataNascimento, nome);
	}

	public void calculaPrioridade(boolean[] respostas) {
		int soma = 0;
		for (int i = 0; i < respostas.length; i++) {
			if (respostas[i])
				soma++;
		}
		prioridade = soma;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		if (estado > 0)
			this.estado = estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		if (medico != null)
			this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		if (paciente != null)
			this.paciente = paciente;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atendimento [prioridade=");
		builder.append(prioridade);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", medico=");
		builder.append(medico);
		builder.append(", paciente=");
		builder.append(paciente);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
