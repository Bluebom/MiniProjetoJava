package br.com.app;

import java.util.Scanner;

import br.com.projetoLista.ListaAlunos;
import br.com.projetoLista.ListaDisciplinas;

public class App {

	public static char menuAluno() {
		String msg;
		System.out.println("\n     Escolha uma opção      \n");
		System.out.println("::::::::::::::::::::::::::::::\n");
		System.out.println(": 1.   Inserir Aluno     		");
		System.out.println(": 2.   Localizar Aluno por RGM  ");
		System.out.println(": 3.   Excluir Aluno por RGM    ");
		System.out.println(": 4.   Mostrar Alunos           ");
		System.out.println(": 5.   Sair do Programa         ");
		System.out.println("\n::::::::::::::::::::::::::::::\n");
		msg = new Scanner(System.in).next();
		return msg.charAt(0);
	}
	public static char menuDisciplina() {
		String msg;
		System.out.println("\n     Escolha uma opção      \n");
		System.out.println("::::::::::::::::::::::::::::::\n");
		System.out.println(": 1.   Inserir nova disciplina no início ");
		System.out.println(": 2.   Inserir nova disciplina no fim ");
		System.out.println(": 3.   parar	                ");
		System.out.println("\n::::::::::::::::::::::::::::::\n");
		msg = new Scanner(System.in).next();
		return msg.charAt(0);
	}
	
	public static char openMenu() {
		String msg;
		System.out.println("\n     Escolha uma opção      \n");
		System.out.println("::::::::::::::::::::::::::::::\n");
		System.out.println(": 1.   Mostrar menu             ");
		System.out.println(": 2.   Sair do Programa	        ");
		System.out.println("\n::::::::::::::::::::::::::::\n");
		msg = new Scanner(System.in).next();
		return msg.charAt(0);
	}
	
	public static void main(String[] args) {
		ListaAlunos Alunos = new ListaAlunos();
		Alunos aluno;
		Disciplinas disciplina;
		char opcao, opcaoAluno, opcaoDisciplina;
		int RGM;
		Scanner entrada = new Scanner(System.in);
		do {
			ListaDisciplinas Disciplinas = new ListaDisciplinas();
			
			opcao = openMenu();
			if(opcao == '1') {
				opcaoAluno = menuAluno();
				switch (opcaoAluno) {
				case '1': {
						System.out.println("\nInserir Aluno!");
						aluno = new Alunos();
						System.out.print("Nome do aluno: ");
						aluno.setNome(entrada.next());
						System.out.print("RGM do aluno: ");
						aluno.setRGM(entrada.nextInt());
						entrada.nextLine();
						do {
							disciplina = new Disciplinas();
							opcaoDisciplina = menuDisciplina();
							if(opcaoDisciplina == '1') {
								System.out.print("Inserir disciplina: ");
								disciplina.setNome(entrada.nextLine());
								entrada.nextLine();
								Disciplinas.firstInsert(disciplina);
							}else if(opcaoDisciplina == '2') {
								System.out.print("Inserir disciplina: ");
								disciplina.setNome(entrada.nextLine());
								entrada.nextLine();
								Disciplinas.lastInsert(disciplina);
							}
						}while(opcaoDisciplina != '3');
						aluno.setDisciplinas(Disciplinas);
						Alunos.lastInsert(aluno);
						break;
					}
				case '2': {
					if(Alunos.isEmpty()) {
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						System.out.println("A lista está vazia");
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						break;
					}
					System.out.println("Localizar o Aluno!");
					System.out.print("Digite o RGM do Aluno: ");
					RGM = entrada.nextInt();
					if(Alunos.searchNode(RGM) == null) {
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						System.out.println(RGM+" não está na lista");
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						break;
					}
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					System.out.println(Alunos.searchNode(RGM));
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					break;
				}
				case '3': {
					if(Alunos.isEmpty()) {
						System.out.println("A lista está vazia");
						break;
					}
					System.out.println("Excluir Aluno!");
					System.out.print("Digite o RGM do Aluno a ser retirado da lista: ");
					RGM = entrada.nextInt();
					if(Alunos.searchNode(RGM) == null) {
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						System.out.println(RGM+" não está na lista");
						System.out.println("\n::::::::::::::::::::::::::::::\n");
						break;
					}
					System.out.println("::::::::::::::::::::::::::::::\n");
					Alunos.removeNode(RGM);
					System.out.println("O aluno com RGM: "+RGM+" foi retirada da lista");
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					System.out.println("Motrar todos os Alunos após a remoção!");
					System.out.println("\n::::::::::::::::::::::::::::::");
					System.out.println(Alunos.printList());
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					break;
				}
				case '4': {
					System.out.println("Motrar todos os Alunos!");
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					System.out.println(Alunos.printList());
					System.out.println("\n::::::::::::::::::::::::::::::\n");
					break;
				}
				case '5': {
					System.out.println("Encerar a aplicação.");
					opcao = '2';
					break;
				}
			
				}
			}
		}while(opcao != '2');
		entrada.close();
	}

}
