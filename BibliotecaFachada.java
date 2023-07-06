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
			l.addExemplar(new Exemplar(livro)); //caso um livro com mesmo id seja adicionado, adiciona como exemplar
			return;
		}
		livro.addExemplar(new Exemplar(livro));
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
//**************************************************************************************************	
	public void realizarEmprestimo(String idUsuario, String idLivro) {
		Usuario u = this.pesquisarUsuario(idUsuario);
		Livro   l = this.pesquisarLivro(idLivro);
		
		if(l.getExemplares().isEmpty()) {
			System.out.println("Livro ainda sem exemplares!");
			return;
		}
		
		for(Exemplar e: l.getExemplares()) {
			if(e.isDisponivel()) {
				Emprestimo emprestimo = new Emprestimo(u, e).getEmprestimo();
				if(emprestimo != null) {
					
					u.getEmprestimos().add(emprestimo);
					System.out.println("Usuario: " + u.getNome());
					System.out.println("Livro: " + l.getTitulo());
					System.out.println("Emprestimo realizado!");
					System.out.println("Devolução: " + emprestimo.calcularDataDevolucao());
					return;
				}
				System.out.println("Usuario em débito!");
				return;
			}
		}
		System.out.println("Não há exemplares disponiveis!");
	}
//***********************************************************************************************	
	public void realizarDevolucao(String idUsuario, String idLivro) {
		
		Usuario u = this.pesquisarUsuario(idUsuario);
		Livro   l = this.pesquisarLivro(idLivro);
		
		if(u !=null && l != null) {
					for(Emprestimo emp: u.getEmprestimos()) {      //verifica se há debito
						if(emp.getExemplar().getLivro().getId().equals(l.getId())) {
							emp.setDataDevolucao();
							emp.setEmAndamento(false);
							emp.getExemplar().setDisponivel(true);
							System.out.println("O livro " + l.getTitulo() + " foi devolvido com sucesso!");
							return;
						}
					}	
					System.out.println("Não houve emprestimo do livro: " + l.getTitulo() + "!");
							
		}
		System.out.println("Usuario ou livro inexistente!");	
			
	}
	//************************************************************************************************
	public void realizarReserva(Usuario usuario, Livro livro) {
		
		Usuario u = this.pesquisarUsuario(usuario.getId());
		Livro   l = this.pesquisarLivro(livro.getId());
	}
//*********************************************************************************************	
	public void serObservador(Usuario usuario, Livro livro) {
	}
//**************************************************************************************
	public void obterInformacoesExemplar(Usuario usuario, Livro livro) {
	}
//**********************************************************************************************	
	public void visulizarHistorico(Comando comando, Object...args) {
		Usuario usuario = this.pesquisarUsuario((String)args[1]);
		if(usuario!=null) {
			System.out.println("Historico de emprestimos do usuario " + usuario.getNome() + ":");
			if(usuario.getEmprestimos().isEmpty() == false) {
				
				for(Emprestimo emp: usuario.getEmprestimos()) {
					if(emp.getUsuario().getId().equals(usuario.getId())) {
						
							System.out.println("------------------------------");
							Livro l = fachada.pesquisarLivro(emp.getExemplar().getId());
							System.out.println("Exemplar: " + l.getTitulo());
							System.out.println("Emprestimo: " + emp.getDataEmprestimo());
							System.out.println("Devolução: " + emp.calcularDataDevolucao());
							
							System.out.print("Status: ");
							if(emp.isEmAndamento()&&emp.getUsuario().isDevedor()) {
								System.out.println("Em andamento (atraso)");
							}else if(emp.isEmAndamento()) {
								System.out.println("Em andamento");
							}else {
								System.out.println("Finalizado");
							}
							System.out.println("------------------------------");				
						
					}
				}
				return;
			}			
			System.out.println("Usuario não tem emprestimos!");
			return;
		}
		
	}
	public void notifObservador(Usuario usuario, Livro livro) {
	}
	public void sairDoSistema() {
		System.out.println("programa encerrado!");
		System.exit(0);
	}
	
	
	
}
