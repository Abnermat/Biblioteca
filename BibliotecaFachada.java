package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.command.*;

import trabalhoEngenharia.Usuarios.Usuario;
import trabalhoEngenharia.Itens_biblioteca.Livro;

public class BibliotecaFachada {

	private static BibliotecaFachada fachada;
	
	private List<Usuario> listaDeUsuarios;
	private List<Livro> listaDeLivros;
	
	private BibliotecaFachada() {
		listaDeUsuarios = new ArrayList<Usuario>();
		listaDeLivros = new ArrayList<Livro>();
	}
	
	public static BibliotecaFachada getInstance() { //singleton
		if(fachada == null) {
			fachada = new BibliotecaFachada();
		}
		return fachada;
	}
	
	public void addLivro(Livro livro) {
		this.listaDeLivros.add(livro);
	}
	public void addUsuario(Usuario usuario) {
		this.listaDeUsuarios.add(usuario);
	}
	
	public void solicitarService(Comando c) {
		c.executar(null);
	}
	
	
	public void realizarEmprestimo(Usuario usuario, Livro livro) {
		RealizarEmprestimoCmd emprestimo = new RealizarEmprestimoCmd();
		//emprestimo.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void realizarDevolucao(Usuario usuario, Livro livro) {
		RealizarDevolucaoCmd devolucao = new RealizarDevolucaoCmd();
		//devolucao.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void realizarReserva(Usuario usuario, Livro livro) {
		RealizarReservaCmd reserva = new RealizarReservaCmd();
		//reserva.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void serObservador(Usuario usuario, Livro livro) {
	}
	public void obterInformacoesExemplar(Usuario usuario, Livro livro) {
	}
	public void meusEmprestimos(Usuario usuario, Livro livro) {
	}
	public void notifObservador(Usuario usuario, Livro livro) {
	}
	public void sairDoSistema(Usuario usuario, Livro livro) {
	}
	
	
	
}
