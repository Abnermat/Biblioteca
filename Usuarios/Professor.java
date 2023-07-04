package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.command.Comando;

public class Professor implements Usuario {

	private String id;
	private String nome;
	private BibliotecaFachada fachada;
	private int limiteDiasEmprestimo;
	
	public Professor(String id, String nome, BibliotecaFachada fachada) {
		this.id = id;
		this.nome = nome;
		this.fachada = fachada;
		this.limiteDiasEmprestimo = 7;
	}
	
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void solicitarEmprestimo(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarEmprestimo(comando, usuario, livro);
		
	}

	@Override
	public void devolverExemplar(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarDevolucao(comando, this, livro);
		
	}

	@Override
	public void solicitarReserva(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarReserva(comando, usuario, livro);
		
	}

	@Override
	public int getLimiteDiasEmprestimo() {
		return this.limiteDiasEmprestimo;
	}

}
