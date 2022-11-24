package Atendimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ListaAtendimento {

	private LinkedList<Atendimento> latendimento = new LinkedList<Atendimento>();

	public ListaAtendimento() {
	}

	public void addLista(Date inicio, Date fim, int prioridade, int estado, Medico medico, Date dataNascimento,
			String nome) {
		Atendimento atendimento = new Atendimento(inicio, fim, prioridade, estado, medico, dataNascimento, nome);
		latendimento.add(atendimento);
	}

	public void reorganizarLista() {
		List<Atendimento> aux = new ArrayList<Atendimento>();
		for (Atendimento a : latendimento) {
			aux.add(a);
		}
		latendimento.clear();
		for (Atendimento a : aux) {
			if (latendimento.size() == 0) {
				latendimento.add(a);
			} else {
				for (int i = 0; i < latendimento.size(); i++) {
					if (a.getPrioridade() > latendimento.get(i).getPrioridade()) {
						latendimento.add(i, a);
						return;
					}
				}
				latendimento.add(a);
			}
		}
	}

	public LinkedList<Atendimento> mostrarLista() {
		return latendimento;
	}

	public void setLatendimento(LinkedList<Atendimento> latendimento) {
		if (latendimento != null)
			this.latendimento = latendimento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaAtendimento [latendimento=");
		builder.append(latendimento);
		builder.append("]");
		return builder.toString();
	}

}