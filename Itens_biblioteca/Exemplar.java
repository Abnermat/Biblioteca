package trabalhoEngenharia.Itens_biblioteca;

import java.util.*;

import trabalhoEngenharia.Usuarios.Observer;


public class Exemplar {
//**********************************************
	private static int contador = 1;
	private String id;
	private Livro livro;
	private boolean emprestado;
	
	public Exemplar(Livro livro) {
		this.id = gerarId();
		this.livro = livro;
	}

    private String gerarId() {
        String id = String.format("%02d", contador);
        contador++;
        return id;
    }

    public String getId() {
        return id;
    }

	public String getIdExemplar() {
		return this.id;
	}

	public boolean isEmprestado() {
		return this.emprestado; 
	}


	public void setEmprestado(boolean valor) {
		this.emprestado = valor;
	}

	public Livro getLivro() {
		return this.livro;
	} 
	
		
}
