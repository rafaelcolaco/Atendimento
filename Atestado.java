package Atendimento;

import java.util.Date;

public class Atestado extends Operacao {

	private int cid;

	public Atestado() {
		super();
	}
	
	public Atestado(Date inicio, Date fim) {
		super(inicio, fim);
	}

	public Atestado(Date inicio, Date fim, int cid) {
		super(inicio, fim);
		this.cid = cid;
	}

	public void emitirAtestado(Atendimento atendimento) {
		System.out.println(atendimento.toString());
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		if (cid > 0)
			this.cid = cid;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atestado [cid=");
		builder.append(cid);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
