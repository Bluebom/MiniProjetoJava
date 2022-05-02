package br.com.projetoLista;

import br.com.app.Disciplinas;
import br.com.no.No;

public class ListaDisciplinas {
	protected No<Disciplinas> first;
	protected No<Disciplinas> last;
		
	/**
	*	Garantimos que a lista será inicializada zerada.
	*/
	public ListaDisciplinas() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void firstInsert(Disciplinas content) {
		No<Disciplinas> novoNo = new No<Disciplinas>(content);
		if(this.isEmpty()) {
			this.last = novoNo;
		}
		novoNo.setProx(this.first);
		this.first = novoNo;
		
	}
	
	public void lastInsert(Disciplinas content) {
		No<Disciplinas> novoNo = new No<Disciplinas>(content);
		if(this.isEmpty()) {
			this.first = novoNo;
		}else {
			this.last.setProx(novoNo);	
		}
		this.last = novoNo;
	}

	public String printList() {
		String msg = "";
		if(this.isEmpty()) {
			return "A lista está vazia!";
		}
		No<Disciplinas> atual = this.first;
		while(atual != null) {
			msg += "    + "+ atual.getC().getNome()+ " Nota:"+atual.getC().getNota()+"\n"; 
			atual = atual.getProx();	
		}
		return msg;
	}
}
