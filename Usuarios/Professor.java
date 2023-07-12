package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Exemplar;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Itens_biblioteca.Reserva;
import trabalhoEngenharia.command.Comando;

import java.time.LocalDate;
import java.util.*;

public class Professor implements Usuario, Observer {

	private String id;
	private String nome;
	private int limiteDiasEmprestimo;
	private List<Emprestimo> emprestimos;
	private List<Reserva> reservas;
	private int qtdNotificacoes;
	
	
	public Professor(String id, String nome) {
		this.id = id;
		this.nome = nome;
		this.limiteDiasEmprestimo = 7;
		this.emprestimos = new ArrayList<>();
		this.reservas = new ArrayList<>();
		this.setQtdNotifi(0);
	}
	
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

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

//************************************************
	@Override
	public void notificarSobreReservas(Livro livro) {
		System.out.println("O livro \"" + livro.getTitulo() + "\" tem mais de 2 reservas!" );
		this.qtdNotificacoes++;
		
	}
	public int getQtdNotifi() {
		return qtdNotificacoes;
	}

	public void setQtdNotifi(int qtdNotificacoes) {
		this.qtdNotificacoes = qtdNotificacoes;
	}	
//***********************************************
	@Override
	public List<Reserva> getReservas() {
		return this.reservas;
	}
	@Override
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
		
	}


	@Override
	public void addEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
		
	}


}
