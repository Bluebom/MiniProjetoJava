package br.com.projetoLista;

import java.util.Arrays;

import br.com.app.Alunos;

public class ListaAlunos{
	private Object[] elements;
	private int posicao;
	

	public ListaAlunos() {
		this.elements = new Object[60];
		this.posicao = 0;
	}
	
	public void inserir(Alunos element) 
	{
		if(this.posicao >= this.elements.length) {
			System.out.println("O número máximo de alunos foi alcançado.");
		}
		this.elements[this.posicao] = element;
		this.posicao++;
	}
	
	public int recuperaIndiceByRgm(int rgm) {
		for(int i = 0; i < this.posicao; i++) {
			Alunos elem = (Alunos)this.elements[i];
			if(elem != null && elem.getRGM() == rgm) {
				return i;
			}
		}
		return -1;
	}
	
	public void sortByRgm() {
		for(int i = this.posicao; i > 1 ; i--) {
			for(int j = 0; j < i; j++) {
				Alunos atual = (Alunos)this.elements[j];
				Alunos prox = (Alunos)this.elements[j+1];
				
				if(prox != null && atual.getRGM() > prox.getRGM()) {
					this.swapValues(j, j+1);
				}
			}
		}
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		Alunos temp = (Alunos)this.elements[indexOne];
		this.elements[indexOne] = (Alunos)this.elements[indexTwo];
		this.elements[indexTwo] = temp;
	}
	
	public String recuperar(int rgm) {
		int indice = this.recuperaIndiceByRgm(rgm);
		if(posicao >= tamanho())
			throw new IllegalArgumentException(String.format("A posição é inválida [%d]", posicao));
		if(indice == -1)
			return null;
		Alunos aluno = (Alunos)this.elements[indice];
		if(aluno == null) 
			return null;
		
		return "[Nome: "+ aluno.getNome()+"\nRGM: "+ aluno.getRGM()+"\nDisciplinas:{\n"+
			aluno.getDisciplinas().printList()+"\n}],";
	}
	
	public int tamanho() {
		return this.elements.length;
	}
	
	public boolean isEmpty() {
		return this.posicao == 0;
	}
	
	public void remover(int rgm) {
		int indice = recuperaIndiceByRgm(rgm);
		if(indice >= this.posicao-1) {
			throw new IllegalArgumentException(String.format("A posição é inválida [%d]", indice));
		}
		Object[] arrayFinal = Arrays.copyOfRange(this.elements, indice + 1, tamanho());
		Object[] arrayInicio = Arrays.copyOfRange(this.elements, 0, indice);
		this.elements = new Object[tamanho() - 1];
		this.posicao--;
		System.arraycopy(arrayInicio, 0, this.elements, 0, arrayInicio.length);
		System.arraycopy(arrayFinal, 0, this.elements, arrayInicio.length, arrayFinal.length);
	}
	
	public String printList() {
		String msg = "";
		if(this.isEmpty()) {
			return "A lista está vazia!";
		}
		this.sortByRgm();
		for(int i = 0; i < this.posicao; i++) {
			Alunos aluno = (Alunos)this.elements[i];
			msg +=  "[Nome: "+ aluno.getNome()+"\nRGM: "+ aluno.getRGM()+"\nDisciplinas:{\n"+
			aluno.getDisciplinas().printList()+"\n}],";
		}
		return msg;
	}
	
	public String printToTXT() {
		String msg = "";
		if(this.isEmpty()) {
			return "A lista está vazia!";
		}
		this.sortByRgm();
		for(int i = 0; i < this.posicao; i++) {
			Alunos aluno = (Alunos)this.elements[i];
			msg +=  "[Nome: "+ aluno.getNome()+" | RGM: "+ aluno.getRGM()+"]\n";
		}
		return msg;
	}
}
