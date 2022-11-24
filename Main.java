package Atendimento;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// inicializa��o
		System.out.println("- ATENDIMENTO M�DICO -");
		Scanner sc = new Scanner(System.in);
		ListaAtendimento lista = new ListaAtendimento();
		ListaAtendimento atendidos = new ListaAtendimento();
		Atestado atestado;
		int opcao;
		String nome;
		Medico med;
		int id = 0;
		Random randy = new Random();

		// valores para gera��o de m�dicos e pacientes aleat�rios
		Especialidade[] especialidades = { new Especialidade("Cirurgi�o geral"), new Especialidade("Ortopedista"),
				new Especialidade("Pediatra"), new Especialidade("Cardiologista"),
				new Especialidade("Oftalmologista") };
		String[] nomes = { "Jo�o", "Roberto", "Marcos", "Felipe", "Carlos", "Renato", "Ana", "Rebeca", "Raquel",
				"Daniela", "Marcela", "Amanda" };

		// gera��o de 3 m�dicos aleat�rios
		List<Medico> medicos = new ArrayList<Medico>();
		for (int i = 0; i < 3; i++) {
			Medico temp = new Medico(new Date(80, 11, 15), nomes[randy.nextInt(nomes.length)]);
			for (int j = 0; j < especialidades.length; j++) {
				if (randy.nextBoolean()) {
					temp.adicionarEspecialidade(especialidades[j]);
				}
			}
			medicos.add(temp);
		}

		// gera��o de 20 pacientes aleat�rios
		for (int i = 0; i < 20; i++) {
			lista.addLista(
					new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900,
							Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE),
							Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
							Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND)),
					null, randy.nextInt(5), 0, null, new Date(80, 11, 15), nomes[randy.nextInt(nomes.length)]);
			lista.reorganizarLista();
		}

		// menu
		do {
			System.out.println("Selecione uma op��o:");
			System.out.println("1 = Mostrar fila");
			System.out.println("2 = Inserir paciente");
			System.out.println("3 = Atender paciente");
			System.out.println("4 = Mostrar hist�rico geral");
			System.out.println("5 = Mostrar hist�rico de um m�dico");
			System.out.println("6 = Mostrar m�dicos");
			System.out.println("0 = Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				// mostrar fila
				System.out.println("Fila:");
				for (Atendimento a : lista.mostrarLista()) {
					System.out.println(a.toString());
				}
				break;
			case 2:
				// inserir paciente
				do {
					System.out.println("Informe o nome do paciente:");
					nome = sc.next();
				} while (nome == null);
				System.out.println("Informe o ano de nascimento do paciente:");
				int ano = sc.nextInt();
				int mes;
				do {
					System.out.println("Informe o m�s de nascimento do paciente:");
					mes = sc.nextInt();
				} while (mes < 1 || mes > 12);
				int dia;
				do {
					System.out.println("Informe o dia de nascimento do paciente:");
					dia = sc.nextInt();
				} while (dia < 1 || dia > 31);
				Date data = new Date(ano - 1900, mes - 1, dia);

				lista.addLista(new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900,
						Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE),
						Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE),
						Calendar.getInstance().get(Calendar.SECOND)), null, 0, 0, null, data, nome);

				// perguntas
				boolean[] respostas = new boolean[4];
				int resposta;
				do {
					System.out.println("Os sintomas do paciente s�o agudos/severos? 1 = Sim, 0 = N�o:");
					resposta = sc.nextInt();
				} while (resposta != 1 && resposta != 0);
				if (resposta == 1)
					respostas[0] = true;
				else
					respostas[0] = false;
				do {
					System.out.println("O paciente est� perdendo sangue? 1 = Sim, 0 = N�o:");
					resposta = sc.nextInt();
				} while (resposta != 1 && resposta != 0);
				if (resposta == 1)
					respostas[1] = true;
				else
					respostas[1] = false;
				do {
					System.out.println("O paciente possui anemia? 1 = Sim, 0 = N�o:");
					resposta = sc.nextInt();
				} while (resposta != 1 && resposta != 0);
				if (resposta == 1)
					respostas[2] = true;
				else
					respostas[2] = false;
				do {
					System.out.println("O paciente possui diabetes? 1 = Sim, 0 = N�o:");
					resposta = sc.nextInt();
				} while (resposta != 1 && resposta != 0);
				if (resposta == 1)
					respostas[3] = true;
				else
					respostas[3] = false;

				lista.mostrarLista().getLast().calculaPrioridade(respostas);
				lista.reorganizarLista();

				break;
			case 3:
				// atender paciente
				do {
					System.out.println("Informe o nome do m�dico que vai atender o paciente:");
					nome = sc.next();
				} while (nome == null);
				med = null;
				for (Medico m : medicos) {
					if (nome.equalsIgnoreCase(m.getNome())) {
						med = m;
						break;
					}
				}
				if (med != null) {
					Atendimento aux = lista.mostrarLista().getFirst();
					aux.setMedico(med);
					aux.setEstado(1);
					aux.setFim(new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900,
							Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE),
							Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
							Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND)));
					atendidos.mostrarLista().add(aux);
					System.out.println("Paciente atendido:");
					Date agora = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900,
							Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE),
							Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
							Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND));
					atestado = new Atestado(agora, agora, id);
					id++;
					atestado.emitirAtestado(aux);
					lista.mostrarLista().removeFirst();
				} else {
					System.out.println("M�dico n�o encontrado!");
				}
				break;
			case 4:
				// hist�rico geral
				System.out.println("Hist�rico geral:");
				System.out.println("Pacientes atendidos:");
				for (Atendimento a : atendidos.mostrarLista()) {
					System.out.println(a.toString());
				}
				System.out.println("Pacientes em espera:");
				for (Atendimento a : lista.mostrarLista()) {
					System.out.println(a.toString());
				}
				break;
			case 5:
				// hist�rico de um m�dico
				do {
					System.out.println("Informe o nome do m�dico:");
					nome = sc.next();
				} while (nome == null);
				med = null;
				for (Medico m : medicos) {
					if (nome.equalsIgnoreCase(m.getNome())) {
						med = m;
						break;
					}
				}
				if (med != null) {
					System.out.println("Pacientes atendidos:");
					for (Atendimento a : atendidos.mostrarLista()) {
						if (a.getMedico() == med) {
							Date agora = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900,
									Calendar.getInstance().get(Calendar.MONTH),
									Calendar.getInstance().get(Calendar.DATE),
									Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
									Calendar.getInstance().get(Calendar.MINUTE),
									Calendar.getInstance().get(Calendar.SECOND));
							atestado = new Atestado(agora, agora, id);
							id++;
							atestado.emitirAtestado(a);
						}
					}
				} else {
					System.out.println("M�dico n�o encontrado!");
				}
				break;
			case 6:
				for (Medico m : medicos) {
					System.out.println(m.toString());
				}
				break;
			case 0:
				// sair
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Valor inv�lido!");
				break;
			}
		} while (opcao != 0);

		sc.close();
	}
}
