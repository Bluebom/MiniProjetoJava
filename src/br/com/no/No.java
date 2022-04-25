package br.com.no;


public class No<T> {
	private T content;
	private No<T> prox;
	
	/**
	 * novo nó da lista, aponta para null
	 * 
	 * @param Pessoa pss 
    */
	public No(T c) {
		this.content = c;
		this.prox = null;
	}

	public T getC() {
		return content;
	}

	public void setC(T c) {
		this.content = c;
	}

	public No<T> getProx() {
		return prox;
	}

	public void setProx(No<T> prox) {
		this.prox = prox;
	}
}
