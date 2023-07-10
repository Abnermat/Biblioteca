package trabalhoEngenharia.Usuarios;

import java.time.LocalDate;
import java.util.*;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Itens_biblioteca.Reserva;
import trabalhoEngenharia.command.Comando;

public class AlunoPos implements Usuario {

	private String id;
	private String nome;
	private BibliotecaFachada fachada;
	private int limiteDiasEmprestimo;
	private List<Emprestimo> emprestimos;
	public List<Reserva> reservas;
	
	public AlunoPos(String id, String nome, BibliotecaFachada fachada) {
		this.id = id;
		this.nome = nome;
		this.fachada = fachada;
		this.limiteDiasEmprestimo = 4;
		this.emprestimos = new ArrayList<>();
	}
	
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	/*@Override
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
	}*/

	@Override
	public int getLimiteDiasEmprestimo() {
		return this.limiteDiasEmprestimo;
	}


	@Override
	public List<Emprestimo> getEmprestimos() {
		return this.emprestimos;
	}


	@Override
	public boolean isDevedor() {
		if (this.getEmprestimos().isEmpty())
			return false;
		int diaAtual = LocalDate.now().getDayOfYear();
		for (Emprestimo emp: this.emprestimos) {
			int diaDevolucao = emp.getDataDevolucao().getDayOfYear();
			if (diaAtual>diaDevolucao) {
				return true;
			}
		}
		return false;
	}


	@Override
	public List<Reserva> getReservas() {
		return this.reservas;
	}


	@Override
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
		
	}

}
