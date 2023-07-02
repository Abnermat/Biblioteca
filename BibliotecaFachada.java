package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.Usuarios.Usuario;
import trabalhoEngenharia.command.Comando;
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
	
	public boolean constamNaLista (Object...args) {
		if((this.pesquisarUsuario((String) args[1]))!= null && (this.pesquisarLivro((String) args[2]))!= null) {
			return true;
		}
		return false;
	}
	//**********************************
	private Usuario pesquisarUsuario(String id) {
		for(Usuario u: this.listaDeUsuarios) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		System.out.println("Usuario nao encontrado!");
		return null;
	}
	
	private Livro pesquisarLivro(String id) {
		for(Livro l: this.listaDeLivros) {
			if(l.getId().equals(id)) {;
				return l;
			}
		}
		System.out.println("Livro nao encontrado!");
		return null;
	}
	//************************************************
	public void realizarEmprestimo(Comando comando, Usuario usuario, Livro livro) {
		Usuario u = this.pesquisarUsuario(usuario.getId());
		Livro   l = this.pesquisarLivro(livro.getId());
		
		if(u !=null && l != null)
			comando.executar(this, usuario, livro);
	}
	
	public void realizarDevolucao(Comando comando, Usuario usuario, Livro livro) {
		
		Usuario u = this.pesquisarUsuario(usuario.getId());
		Livro   l = this.pesquisarLivro(livro.getId());
		
		if(u !=null && l != null)
			comando.executar(this, usuario, livro);
	}
	
	public void realizarReserva(Comando comando, Usuario usuario, Livro livro) {
		
		Usuario u = this.pesquisarUsuario(usuario.getId());
		Livro   l = this.pesquisarLivro(livro.getId());
		
		if(u !=null && l != null)
			comando.executar(this, usuario, livro);
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
