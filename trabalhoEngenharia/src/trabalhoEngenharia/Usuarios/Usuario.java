package trabalhoEngenharia.Usuarios;

import java.util.List;

import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Reserva;

public interface Usuario {
	public String getId();
	public String getNome();
	public int getLimiteDiasEmprestimo();
	public List<Emprestimo> getEmprestimos();
	public boolean addEmprestimo(Emprestimo emprestimo);
	public boolean isDevedor();
	public List<Reserva> getReservas();
	public void addReserva(Reserva reserva);
	
}
