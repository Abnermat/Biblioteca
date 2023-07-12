package trabalhoEngenharia.Itens_biblioteca;

import java.util.*;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Usuarios.*;
import trabalhoEngenharia.Usuarios.Observer;

public class Livro {
	    private String id;
	    private String titulo;
	    private String editora;
	    private List<String> autores;
	    private int edicao;
	    private int dataDePublicacao;
	    private List<Exemplar> exemplares;
		private List<Reserva> reservas;
		private List<Observer> observadores;
	
	    public Livro(String id, String titulo, String editora, int edicao, int dataDePublicacao, String...autores) {
	        this.id = id;
	        this.titulo = titulo;
	        this.editora = editora;
	        this.autores = List.of(autores);
	        this.edicao = edicao;
	        this.dataDePublicacao = dataDePublicacao;
	        this.exemplares = new ArrayList<Exemplar>();
	        this.reservas = new ArrayList<>();
	        this.observadores = new ArrayList<>();
	    }
	
	    public String getId() {
	        return id;
	    }
	
	    public String getTitulo() {
	        return titulo;
	    }
	
	    public String getEditora() {
	        return editora;
	    }
	
	    public List<String> getAutores() {
	        return autores;
	    }
	
	    public int getEdicao() {
	        return edicao;
	    }
	
	    public int getDataDePublicacao() {
	        return dataDePublicacao;
	    }
	
	    public void addExemplar(Exemplar exemplar) {
	        this.exemplares.add(exemplar);
	    }
	    public List<Exemplar> getExemplares(){
	    	return this.exemplares;
	    }
	//*********************************************    
    
	    public void addObservador(Observer observador) {
	    	this.observadores.add(observador);
	    }	
		private void notificarObs() {
			for(Observer obs: this.observadores) {
				obs.notificarSobreReservas(this);
			}
		}
	//*********************************************	
	    public void addReserva(Reserva reserva) {
	    	this.reservas.add(reserva);
	    	if(this.reservas.size() > 2)
	    		this.notificarObs();
	    	
	    }
		public List<Reserva> getReservas(){
			return this.reservas;
		}
		public Usuario getPrimeiroFilaReservas() {
			return this.reservas.get(0).getUsuario();
		}
		public void removerPrimeiroFilaReservas(){
			this.reservas.remove(0);
		}
		public Exemplar exemplarDisponivel() {
			for(Exemplar e: this.getExemplares()) {
				if(e.isDisponivel()) {
					return e;
				}
			}
			return null;
		}
		public int qtdReservasUsuario(Usuario usu) {
			int cont = 0;
			for(Reserva r: this.reservas) {
				if(r.getUsuario().equals(usu))
					cont++;
			}
			return cont;
		}
		
		public int getQtdReservasTotal() {
			return this.reservas.size();
		}
		
		public void exibirNomesUsuariosReserva() {
			if(this.reservas.isEmpty() != false) {
				for(Reserva r: this.reservas) {
					System.out.println("  -" + r.getUsuario().getNome());
				}
			}
		}
		public void exibirStatusExemplares(BibliotecaFachada b) {
			if(this.exemplares.isEmpty() != false) {
				for(Exemplar e: this.exemplares) {
					System.out.println("Exemplar: " + e.getId());
					if(e.isDisponivel() == false) {
						b.exibirInformacoesEmprestimo(e);
						return;
					}
				}
			}else if(this.exemplares.isEmpty() == true){
				 System.out.println("Livro sem exemplares na Biblioteca!");	
			}
	
		}
	    
 }