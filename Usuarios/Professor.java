package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.command.Comando;

public class Professor implements Usuario {

	private String id;
	private String nome;
	private BibliotecaFachada fachada;
	
	
	public Professor(String id, String nome, BibliotecaFachada fachada) {
		this.id = id;
		this.nome = nome;
		this.fachada = fachada;
	}
	
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
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

}
