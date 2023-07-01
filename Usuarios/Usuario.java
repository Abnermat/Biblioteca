package trabalhoEngenharia.Usuarios;

public interface Usuario {
	public String getId();
	public String getNome();
	public void solicitarEmprestimo(String codUsu, String codLivro);
	public void devolverExemplar(String codUsu, String codLivro);
	public void solicitarReserva(String codUsu, String codLivro);
}
