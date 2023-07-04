package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.Usuarios.Usuario;
import trabalhoEngenharia.command.Comando;
import trabalhoEngenharia.command.VisualizarHistoricoCmd;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Exemplar;
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
		Livro l = this.pesquisarLivro(livro.getId());
		if(l != null) {
			System.out.println("O livro já consta no acervo, será adicionado outro exemplar!");
			l.addExemplar(new Exemplar(livro.getId())); //caso um livro com mesmo id seja adicionado, adiciona como exemplar
			return;
		}
		livro.addExemplar(new Exemplar(livro.getId()));
		this.listaDeLivros.add(livro);
		
	}
	public void addUsuario(Usuario usuario) {
		Usuario u = this.pesquisarUsuario(usuario.getId());
		if(u == null) {
			this.listaDeUsuarios.add(usuario);
			return;
		}
		System.out.println("Id de usuario já cadastrado!");
	}
	
	//**********************************
	public Usuario pesquisarUsuario(String id) {
		for(Usuario u: this.listaDeUsuarios) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}
	
	public Livro pesquisarLivro(String id) {
		for(Livro l: this.listaDeLivros) {
			if(l.getId().equals(id)) {;
				return l;
			}
		}
		return null;
	}
	//************************************************
	//public List<Emprestimo> getEmprestimos() {
	//	return emprestimos;
	//}
	
	public void service(Comando comando, Object...args) {
		comando.executar(fachada, args);
	}
	
	/*public void realizarEmprestimo(Comando comando, Usuario usuario, Livro livro) {
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
	
	public void visulizarHistorico(Comando comando, Object...args) {
		Usuario u = this.pesquisarUsuario((String)args[1]);  //pesquisa usuario atraves do nome
		
		comando.executar(this, u);
		
	}
	public void notifObservador(Usuario usuario, Livro livro) {
	}
	public void sairDoSistema(Usuario usuario, Livro livro) {
	}*/
	
	
	
}
