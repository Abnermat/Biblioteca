package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.command.Comando;

public class AlunoGraduacao implements Usuario {

	private String id;
	private String nome;
	private BibliotecaFachada fachada;
	private int limiteDiasEmprestimo;
	
	
	public AlunoGraduacao(String id, String nome, BibliotecaFachada fachada) {
		this.id = id;
		this.nome = nome;
		this.fachada = fachada;
		this.limiteDiasEmprestimo = 3;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void solicitarEmprestimo(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarEmprestimo(comando, this, livro);	
	}

	@Override
	public void devolverExemplar(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarDevolucao(comando, this, livro);	
	}

	@Override
	public void solicitarReserva(Comando comando, Usuario usuario, Livro livro) {
		this.fachada.realizarReserva(comando, this, livro);	
	}

	@Override
	public int getLimiteDiasEmprestimo() {
		return limiteDiasEmprestimo;
	}



}
