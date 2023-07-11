package trabalhoEngenharia.Usuarios;

import java.util.List;

import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.command.Comando;

public interface Usuario {
	public String getId();
	public String getNome();
	public int getLimiteDiasEmprestimo();
	public List<Emprestimo> getEmprestimos();
	public List<Reserva> getReservar();
	/*public void solicitarEmprestimo (Comando comando, Usuario usuario, Livro livro);
	public void devolverExemplar(Comando comando, Usuario usuario, Livro livro);
	public void solicitarReserva(Comando comando, Usuario usuario, Livro livro);*/
}
