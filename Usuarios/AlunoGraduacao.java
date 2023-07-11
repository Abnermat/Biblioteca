package trabalhoEngenharia.Usuarios;

import java.time.LocalDate;
import java.util.*;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Itens_biblioteca.Reserva;
import trabalhoEngenharia.command.Comando;

public class AlunoGraduacao implements Usuario {

	private String id;
	private String nome;
	private int limiteDiasEmprestimo;
	private List<Emprestimo> emprestimos;
	public List<Reserva> reservas;
	
	
	public AlunoGraduacao(String id, String nome) {
		this.id = id;
		this.nome = nome;
		this.limiteDiasEmprestimo = 3;
		this.emprestimos = new ArrayList<>();
		this.reservas = new ArrayList<>();
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
	public int getLimiteDiasEmprestimo() {
		return limiteDiasEmprestimo;
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
