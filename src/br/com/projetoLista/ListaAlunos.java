package br.com.projetoLista;

import br.com.app.Alunos;
import br.com.no.No;

public class ListaAlunos{
	protected No<Alunos> first;
	protected No<Alunos> last;
		
	/**
	*	Garantimos que a lista será inicializada zerada.
	*/
	public ListaAlunos() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void firstInsert(Alunos content) {
		No<Alunos> novoNo = new No<Alunos>(content);
		if(this.isEmpty()) {
			this.last = novoNo;
		}
		novoNo.setProx(this.first);
		this.first = novoNo;
		
	}
	
	public void lastInsert(Alunos content) {
		No<Alunos> novoNo = new No<Alunos>(content);
		if(this.isEmpty()) {
			this.first = novoNo;
		}else {
			this.last.setProx(novoNo);	
		}
		this.last = novoNo;
	}

	public boolean removeNode(int RGM) {
		No<Alunos> current = this.first;
		No<Alunos> previous = null;
		if(this.isEmpty()) {
			return false;	
		}
		while(current != null && !(current.getC().getRGM() == RGM)) {
			previous = current;
			current = current.getProx();
		}
		if(current == this.first) {
			if(this.first == this.last) {
				this.last = null;
			}
			this.first = this.first.getProx();
		}else {
			if(current == this.last) {
				this.last = previous;
			}
			previous.setProx(current.getProx());	
			current = current.getProx();
		}
		
		return true;
	}

	public String searchNode(int RGM) {
		No<Alunos> current = this.first;
		while(current != null && !(current.getC().getRGM() == RGM)) {
			current = current.getProx();
		}
		if(current == null) {
			return "Aluno de RMG: "+RGM+" não localizado";
		}
		String msg = "Nome: "+ current.getC().getNome();
		msg += "\nDisciplinas:\n"+current.getC().getDisciplinas().printList()+"\n";
		return msg;
	}

	public String printList() {
		String msg = "";
		if(this.isEmpty()) {
			return "A lista está vazia!";
		}
		No<Alunos> atual = this.first;
		while(atual != null) {
			msg += "Nome: "+ atual.getC().getNome();
			msg += "\nRGM: "+ atual.getC().getRGM();
			msg += "\nDisciplinas:\n"+atual.getC().getDisciplinas().printList()+"-> ";
			atual = atual.getProx();	
		}
		return msg;
	}
}
