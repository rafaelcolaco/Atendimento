package Atendimento;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

	private List<Especialidade> lespecialidade = new ArrayList<Especialidade>();

	public Medico() {
		super();
	}

	public Medico(Date dataNascimento, String nome) {
		super(dataNascimento, nome);
	}

	public boolean adicionarEspecialidade(Especialidade especialidade) {
		return lespecialidade.add(especialidade);
	}
	
	public List<Especialidade> getLespecialidade() {
		return lespecialidade;
	}

	public void setLespecialidade(List<Especialidade> lespecialidade) {
		if (lespecialidade != null)
			this.lespecialidade = lespecialidade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [lespecialidade=");
		builder.append(lespecialidade);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
