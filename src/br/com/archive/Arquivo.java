package br.com.archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	static String path = "/home/franklin/workspace/MiniProjeto/extensao.txt";
	
	public static String Read() {
		String Conteudo = "";
		try {
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while(linha != null) {
					Conteudo += linha+"\n";
					linha = lerArq.readLine();
				}
				arq.close();
				return Conteudo;
			} catch (IOException ex) {
				System.out.println("Erro: não foi possível ler o arquivo!");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Erro: Arquivo não encontrado!");
		}
		return "";
	}
	
	public static boolean Write(String texto) {
		try {
			FileWriter arq = new FileWriter(path);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(texto);
			gravarArq.close();
			return true;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean Delete() {
		File arq = new File(path);
		if(arq.exists())
			return arq.delete();
		return false;
	}
	
}
