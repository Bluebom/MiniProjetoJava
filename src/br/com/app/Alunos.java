package br.com.app;

import br.com.projetoLista.ListaDisciplinas;

public class Alunos {
	private String nome;
	private int RGM;
	private ListaDisciplinas disciplinas;
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRGM() {
		return this.RGM;
	}
	public void setRGM(int RGM) {
		this.RGM = RGM;
	}
	public ListaDisciplinas getDisciplinas() {
		return this.disciplinas;
	}
	public void setDisciplinas(ListaDisciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
