package Atendimento;

import java.util.Date;
import java.sql.Time;

public class Operacao {

	private Date inicio;
	private Date fim;

	public Operacao() {
	}

	public Operacao(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	@SuppressWarnings("deprecation")
	public Time tempoTotal() {
		Time tempo = new Time(fim.getTime() - inicio.getTime());
		if (fim.getDate() - inicio.getDate() != 0) {
			tempo.setTime(tempo.getTime() + new Time(23, 59, 59).getTime());
		}
		return tempo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		if (inicio != null)
			this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		if (fim != null)
			this.fim = fim;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operacao [inicio=");
		builder.append(inicio);
		builder.append(", fim=");
		builder.append(fim);
		builder.append("]");
		return builder.toString();
	}

}
