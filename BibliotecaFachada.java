package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.Usuarios.Usuario;
import trabalhoEngenharia.Usuarios.Observer;
import trabalhoEngenharia.Usuarios.Professor;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Exemplar;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Itens_biblioteca.Reserva;

public class BibliotecaFachada {

	private static BibliotecaFachada fachada;
	
	private List<Usuario> listaDeUsuarios;
	private List<Livro> listaDeLivros;
	private List<Emprestimo> emprestimos;
	
	private BibliotecaFachada() {
		this.listaDeUsuarios = new ArrayList<Usuario>();
		this.listaDeLivros = new ArrayList<Livro>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	public static BibliotecaFachada getInstance() { //singleton
		if(fachada == null) {
			fachada = new BibliotecaFachada();
		}
		return fachada;
	}
	
	public void addLivro(Livro livro, int qtd) {
		for(int i=0; i<qtd; i++) {
			livro.addExemplar(new Exemplar(livro));
		}
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
		if(u.isDevedor()) {
			System.out.println("Usuario em débito!");  
			return;
		}
		
		if(l.getReservas().isEmpty() == false) {
			if(l.getPrimeiroFilaReservas().equals(u)) {
				Exemplar e = l.exemplarDisponivel();
				if(e != null) {
					Emprestimo emp = new Emprestimo(u,e);
					u.addEmprestimo(emp);
					this.emprestimos.add(emp);
					l.removerPrimeiroFilaReservas();
					return;
				}else {
					System.out.println("Não há exemplares disponiveis no momento!");
					return;
				}
				
			}
		}else {
			Exemplar e = l.exemplarDisponivel();
			if(e != null) {
				Emprestimo emp = new Emprestimo(u,e);
				u.addEmprestimo(emp);
				this.emprestimos.add(emp);
				return;
			}else {
				System.out.println("Não há exemplares disponiveis");
			}
		}
		

	}
//***********************************************************************************************	
	public void realizarDevolucao(String idUsuario, String idLivro) {
		
		Usuario u = this.pesquisarUsuario(idUsuario);
		Livro   l = this.pesquisarLivro(idLivro);
		
		if(u !=null && l != null) {
					for(Emprestimo emp: u.getEmprestimos()) {  
						if(emp.getExemplar().getLivro().getId().equals(l.getId())) {
							emp.setDataDevolucao();
							emp.setEmAndamento(false);
							emp.getExemplar().disponibilizar();
							System.out.println("O livro \"" + l.getTitulo() + "\" foi devolvido com sucesso!");
							return;
						}
					}	
					System.out.println("Não houve emprestimo do livro: \"" + l.getTitulo() + "\"!");
					return;
							
		}
		System.out.println("Usuario ou livro inexistente!");	
			
	}
	//************************************************************************************************
	public void realizarReserva(String idUsuario, String idLivro) {
		
		Usuario u = this.pesquisarUsuario(idUsuario);
		Livro   l = this.pesquisarLivro(idLivro);
			
		if(u == null || l == null) {
			System.out.println("Usuario ou livro inexistente!");
			return;
		}
		
		if(l.qtdReservasUsuario(u) == 3) {
			System.out.println("Limite de reservas alcançado! (3 reservas em aberto)");
			return;
		}
		Reserva NovaReserva = new Reserva(u, l);
		
		l.addReserva(NovaReserva);
		System.out.println("O usuario " + u.getNome() + " reservou o livro \"" + l.getTitulo() + "\"");
		
	}
//*********************************************************************************************	
	public void serObservador(String idObservador, String idLivro) {
		
		try {
			
			Observer u = (Professor) this.pesquisarUsuario(idObservador);
			Livro   l = this.pesquisarLivro(idLivro);
			
			if(u != null && l != null) {
				
				l.addObservador(u);
				System.out.println(u.getNome() + ", você agora é observador do livro: \"" + l.getTitulo() + "\"") ;
				return;
			}
			
		}catch(RuntimeException e) {
			System.out.println("Comando restrito a professores!");
		}

		
	}
//**************************************************************************************
	public void obterInformacoesLivro(String idLivro) {
		Livro livro = this.pesquisarLivro(idLivro);
		
		if(livro != null) {
			System.out.println("Livro: " + livro.getTitulo());
			System.out.println("Quantidade de reservas: " + livro.getQtdReservasTotal());
			if(livro.getReservas().isEmpty() != false) {
				for(Reserva r: livro.getReservas()) {
					System.out.println("  -" + r.getUsuario().getNome());
				}
			}
			System.out.println("Exemplares: ");
			if(livro.getExemplares().isEmpty() != true) {
				for(Exemplar e: livro.getExemplares()) {
					System.out.println("  exemplar " + e.getId() + " (" + e.minhaDisponibilidade() + ")");
					for(Emprestimo emp: this.emprestimos) {
						if(e.equals(emp.getExemplar())){
							System.out.println("    Emprestado a: " + emp.getUsuario().getNome());
							System.out.println("    Data do emprestimo: " + emp.getDataEmprestimo());
							System.out.println("    Data de devolução: " + emp.getDataDevolucao());
						}
					}
				}
			}
		}
	}
//**********************************************************************************************	
	public void visulizarHistorico(String idUsuario) {
		Usuario usuario = this.pesquisarUsuario(idUsuario);
		if(usuario!=null) {
			System.out.println("Historico de emprestimos do usuario " + usuario.getNome() + ":");
			if(usuario.getEmprestimos().isEmpty() == false) {
				
				for(Emprestimo emp: usuario.getEmprestimos()) {
					if(emp.getUsuario().getId().equals(usuario.getId())) {
						
							System.out.println("------------------------------");
							Livro l = fachada.pesquisarLivro(emp.getExemplar().getLivro().getId());
							System.out.println("Livro: " + l.getTitulo());
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
//*************************************
	public void sairDoSistema() {
		System.out.println("programa encerrado!");
		System.exit(0);
	}
//***************************************
	public void visualizarQtdNtf(String idObservador) {
		try {
			
			Usuario u = this.pesquisarUsuario(idObservador);
			if(u==null) {
				System.out.println("Usuario não encontrado!");
				return;
			}
			Professor p = (Professor)u;
			System.out.println(p.getNome() + ", você foi notificado " + p.getQtdNotifi() + " vez(es)!") ;
			
		}catch(RuntimeException e){
			System.out.println("Comando não disponível para alunos!");
		}

		
	}
	public void registrarEmprestimo(Emprestimo emp) {
		this.emprestimos.add(emp);
	}
	public void exibirInformacoesEmprestimo(Exemplar exemplar) {
		if(this.emprestimos.isEmpty() != false) {
			for(Emprestimo emp: this.getInstance().emprestimos) {
				if(exemplar.equals(emp.getExemplar())){
					System.out.println("Usuario: " + emp.getUsuario().getNome());
					System.out.println("Emprestimo: " + emp.getDataEmprestimo());
					System.out.println("Devolução: " + emp.getDataDevolucao());
				}
			}			
		}

	}
	
}
