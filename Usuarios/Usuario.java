package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.command.Comando;

public interface Usuario {
	public String getId();
	public String getNome();
	public int getLimiteDiasEmprestimo();
	public void solicitarEmprestimo (Comando comando, Usuario usuario, Livro livro);
	public void devolverExemplar(Comando comando, Usuario usuario, Livro livro);
	public void solicitarReserva(Comando comando, Usuario usuario, Livro livro);
}
