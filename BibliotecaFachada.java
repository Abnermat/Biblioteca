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
	
	public void realizarEmprestimo(String codigo, Usuario usuario, Livro livro) {
		RealizarEmprestimoCmd emprestimo = new RealizarEmprestimoCmd(usuario, livro);
		emprestimo.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void realizarDevolucao(String codigo, Usuario usuario, Livro livro) {
		RealizarDevolucaoCmd devolucao = new RealizarDevolucaoCmd(usuario, livro);
		devolucao.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void realizarReserva(String codigo, Usuario usuario, Livro livro) {
		RealizarReservaCmd reserva = new RealizarReservaCmd(usuario, livro);
		reserva.executar(codigo, usuario.getId(), livro.getId());
	}
	
	public void serObservador(String codigo, Usuario usuario, Livro livro) {
	}
	public void obterInformacoesExemplar(String codigo, Usuario usuario, Livro livro) {
	}
	public void meusEmprestimos(String codigo, Usuario usuario, Livro livro) {
	}
	public void notifObservador(String codigo, Usuario usuario, Livro livro) {
	}
	public void sairDoSistema(String codigo, Usuario usuario, Livro livro) {
	}
	
	
	
}
